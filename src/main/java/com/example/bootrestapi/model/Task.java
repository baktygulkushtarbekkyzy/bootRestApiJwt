package com.example.bootrestapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.CascadeType.*;


@Entity
@Table(name = "tasks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "task_gen")
    @SequenceGenerator(name = "task_gen",sequenceName = "task_seq",allocationSize = 1)
    private Long id;
    private String taskName;
    private String taskText;
    private String deadline;

    @ManyToOne(cascade = {PERSIST,MERGE,REFRESH,DETACH})
    private Lesson lesson;

}
