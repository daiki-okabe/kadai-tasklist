package controllers;

import java.io.IOException;
import java.sql.Timestamp;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Task;
import utils.DBUtil;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String _token = request.getParameter("_token");
        if(_token != null && _token.equals(request.getSession().getId())) {
            EntityManager em = DBUtil.createEntityManager();

            // セッションスコープからメッセージのIDを取得して
            // 該当のIDのメッセージ1件のみをデータベースから取得
            Task t = em.find(Task.class, (Integer)(request.getSession().getAttribute("id")));

            String task_name = request.getParameter("task_name");
            t.setTask_name(task_name);

            String task_detail= request.getParameter("task_detail");
            t.setTask_detail(task_detail);

            Timestamp currentTime = new Timestamp(System.currentTimeMillis());
            t.setUpdate_date(currentTime);

            // データベースを更新
            em.getTransaction().begin();
            em.getTransaction().commit();
            em.close();

            // セッションスコープ上の不要になったデータを削除
            request.getSession().removeAttribute("id");

            // indexページへリダイレクト
            response.sendRedirect(request.getContextPath() + "/index");
        }
    }
}