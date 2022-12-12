package com.example.bootrestapi.serviceImpl;


import com.example.bootrestapi.converter.TaskConverter;
import com.example.bootrestapi.dto.task.TaskRequest;
import com.example.bootrestapi.dto.task.TaskResponse;
import com.example.bootrestapi.model.Lesson;
import com.example.bootrestapi.model.Task;
import com.example.bootrestapi.repository.LessonRepository;
import com.example.bootrestapi.repository.TaskRepository;
import com.example.bootrestapi.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    private final LessonRepository lessonRepository;

    private final TaskConverter taskConverter;

    @Override
    public TaskResponse saveTask(Long lessonId, TaskRequest taskRequest) {
        Lesson lesson = lessonRepository.findById(lessonId).orElseThrow(
                () -> new RuntimeException("not found!!!")
        );
        Task task = taskConverter.create(taskRequest);
        lesson.addTask(task);
        task.setLesson(lesson);
        taskRepository.save(task);
       return taskConverter.convertToResponse(task);
    }

    @Override
    public TaskResponse updateTask(Long id, TaskRequest taskRequest) {
        Task task = taskRepository.findById(id).orElseThrow(
                () -> new RuntimeException("not found!!!")
        );
        task.setTaskName(taskRequest.getTaskName());
        task.setTaskText(taskRequest.getTaskText());
        task.setDeadline(taskRequest.getDeadline());
        taskRepository.save(task);
        return taskConverter.convertToResponse(task);
    }

    @Override
    public TaskResponse getById(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(
                () -> new RuntimeException("not found!!!")
        );
        return taskConverter.convertToResponse(task);
    }

    @Override
    public List<TaskResponse> getAllTask() {
        List<TaskResponse> taskResponses=new ArrayList<>();
        for (Task t:taskRepository.findAll()) {
            taskResponses.add(taskConverter.convertToResponse(t));
        }
        return taskResponses;
    }

    @Override
    public TaskResponse deleteTaskById(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(
                () -> new RuntimeException("not found!!!")
        );
        taskRepository.delete(task);
        return taskConverter.convertToResponse(task);
    }
}
