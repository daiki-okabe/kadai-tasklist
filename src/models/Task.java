package models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
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
}
