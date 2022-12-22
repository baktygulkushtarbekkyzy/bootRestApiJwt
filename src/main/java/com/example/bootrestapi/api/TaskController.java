package com.example.bootrestapi.api;

import com.example.bootrestapi.dto.student.StudentRequest;
import com.example.bootrestapi.dto.student.StudentResponse;
import com.example.bootrestapi.dto.task.TaskRequest;
import com.example.bootrestapi.dto.task.TaskResponse;
import com.example.bootrestapi.service.StudentService;
import com.example.bootrestapi.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/tasks")
@PreAuthorize("hasAuthority('ADMIN')")
public class TaskController {
    private final TaskService taskService;

    @GetMapping
    @PreAuthorize("permitAll()")
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
    @PreAuthorize("permitAll()")
    public TaskResponse getById(@PathVariable Long id){
        return taskService.getById(id);
    }

    @DeleteMapping("/{id}")
    public TaskResponse deleteById(@PathVariable Long id){
        return taskService.deleteTaskById(id);
    }
}
