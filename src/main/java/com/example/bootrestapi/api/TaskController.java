package com.example.bootrestapi.api;

import com.example.bootrestapi.dto.student.StudentRequest;
import com.example.bootrestapi.dto.student.StudentResponse;
import com.example.bootrestapi.dto.task.TaskRequest;
import com.example.bootrestapi.dto.task.TaskResponse;
import com.example.bootrestapi.service.StudentService;
import com.example.bootrestapi.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskService taskService;

    @GetMapping
    public List<TaskResponse> getAll(){
        return taskService.getAllTask();
    }

    @PostMapping("/save/{id}")
    public TaskResponse saveInstructor(@PathVariable Long id, @RequestBody TaskRequest taskRequest) throws IOException {
        return taskService.saveTask(id,taskRequest);
    }

    @PostMapping("/{id}")
    public TaskResponse updateCourse(@PathVariable Long id, @RequestBody TaskRequest taskRequest){
        return taskService.updateTask(id, taskRequest);
    }

    @GetMapping("/{id}")
    public TaskResponse getById(@PathVariable Long id){
        return taskService.getById(id);
    }

    @DeleteMapping("/{id}")
    public TaskResponse deleteById(@PathVariable Long id){
        return taskService.deleteTaskById(id);
    }
}
