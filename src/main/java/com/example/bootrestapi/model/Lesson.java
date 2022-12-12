package com.example.bootrestapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "lessons")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "lesson_gen")
    @SequenceGenerator(name = "lesson_gen",sequenceName = "lesson_seq",allocationSize = 1)
    private Long id;
    private String lessonName;

    @ManyToOne(cascade = {PERSIST,MERGE,REFRESH,DETACH})
    private Course course;

    @OneToMany(cascade = ALL,mappedBy = "lesson")
    private List<Task> tasks;

    public void addTask(Task task){
        tasks.add(task);
    }
}
