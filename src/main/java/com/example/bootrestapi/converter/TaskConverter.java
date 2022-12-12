package com.example.bootrestapi.converter;

import com.example.bootrestapi.dto.task.TaskRequest;
import com.example.bootrestapi.dto.task.TaskResponse;
import com.example.bootrestapi.model.Task;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Component
public class TaskConverter {
    public Task create (TaskRequest taskRequest){
        if (taskRequest==null){
            return null;
        }
        Task task =new Task();
        task.setTaskName(taskRequest.getTaskName());
        task.setTaskText(taskRequest.getTaskText());
        task.setDeadline(taskRequest.getDeadline());
        return task;
    }

    public TaskResponse convertToResponse(Task task ){
        return new TaskResponse(task.getId(), task.getTaskName(), task.getTaskText(), task.getDeadline(), task.getLesson().getId());
    }

    public List<TaskResponse> view(List<Task> tasks){
        List<TaskResponse> taskResponses=new ArrayList<>();
        for (Task t:tasks) {
            taskResponses.add(convertToResponse(t));
        }
        return taskResponses;
    }
}
