package com.example.rewards.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="schedule")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "child_name")
    private String childName;
    @Column(name = "task_title")
    private String taskTitle;
    @Column(name = "dayOfWeek")
    private String dayOfWeek;
    @Column(name = "task_id", insertable=false, updatable=false)
    private int taskId;
    @Column(name = "points")
    private int points;
    @Column(name = "child_id", insertable=false, updatable=false)
    private int childId;

    @OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "task_id", referencedColumnName = "id")
    private Task task;

    @OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "child_id", referencedColumnName = "id")
    private Child child;
}
