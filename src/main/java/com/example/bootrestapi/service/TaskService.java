package com.example.bootrestapi.service;

import com.example.bootrestapi.dto.task.TaskRequest;
import com.example.bootrestapi.dto.task.TaskResponse;
import com.example.bootrestapi.model.Task;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface TaskService {

    TaskResponse saveTask(Long lessonId, TaskRequest taskRequest );

    TaskResponse updateTask(Long id,TaskRequest taskRequest );

    TaskResponse getById(Long id);

    List<TaskResponse> getAllTask();

    TaskResponse deleteTaskById(Long id);

}
