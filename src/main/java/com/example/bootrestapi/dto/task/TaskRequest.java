package com.example.bootrestapi.dto.task;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TaskRequest {
    private String taskName;
    private String taskText;
    private String deadline;
    private Long lessonId;
}
