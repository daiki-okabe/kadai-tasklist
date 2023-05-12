package models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({
    @NamedQuery(
        name = "getAllTasks",
        query = "SELECT t FROM Task AS t ORDER BY t.id DESC"
    )
})

@Table(name = "tasks")
public class Task {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "task_name", length = 255, nullable = false)
    private String task_name;

    @Column(name = "task_detail", length = 255, nullable = true)
    private String task_detail;

    @Column(name = "imput_date", nullable = false)
    private Timestamp imput_date;

    @Column(name = "update_date", nullable = false)
    private Timestamp update_date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTask_name() {
        return task_name;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }

    public String getTask_detail() {
        return task_detail;
    }

    public void setTask_detail(String task_detail) {
        this.task_detail = task_detail;
    }

    public Timestamp getImput_date() {
        return imput_date;
    }

    public void setImput_date(Timestamp imput_date) {
        this.imput_date = imput_date;
    }

    public Timestamp getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(Timestamp update_date) {
        this.update_date = update_date;
    }
}
