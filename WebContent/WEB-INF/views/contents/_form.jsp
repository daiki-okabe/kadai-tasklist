<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${errors != null}">
    <div id="flush_error">
        入力内容にエラーがあります。<br />
        <c:forEach var="error" items="${errors}">
            ・<c:out value="${error}" /><br />
        </c:forEach>

    </div>
</c:if>
<label for="task_name">タスク名</label><br />
<input type="text" name="task_name" id="task_name" value="${task.task_name}" />
<br /><br />

<label for="task_detail">タスク詳細</label><br />
<input type="text" name="task_detail" id="task_detail" value="${task.task_detail}" />
<br /><br />

<input type="hidden" name="_token" value="${_token}" />
<button type="submit">追加</button>