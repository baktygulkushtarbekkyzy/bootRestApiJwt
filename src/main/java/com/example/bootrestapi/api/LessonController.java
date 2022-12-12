package com.example.bootrestapi.api;

import com.example.bootrestapi.dto.instructor.InstructorRequest;
import com.example.bootrestapi.dto.instructor.InstructorResponse;
import com.example.bootrestapi.dto.lesson.LessonRequest;
import com.example.bootrestapi.dto.lesson.LessonResponse;
import com.example.bootrestapi.service.InstructorService;
import com.example.bootrestapi.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/lessons")
public class LessonController {
    private final LessonService lessonService;

    @GetMapping
    public List<LessonResponse> getAll(){
        return lessonService.getAllLesson();
    }

    @PostMapping("/save/{id}")
    public LessonResponse saveInstructor(@PathVariable Long id, @RequestBody LessonRequest lessonRequest) throws IOException {
        return lessonService.saveLesson(id,lessonRequest);
    }

    @PostMapping("/{id}")
    public LessonResponse updateCourse(@PathVariable Long id, @RequestBody LessonRequest lessonRequest){
        return lessonService.updateLesson(id, lessonRequest);
    }

    @GetMapping("/{id}")
    public LessonResponse getById(@PathVariable Long id){
        return lessonService.getById(id);
    }

    @DeleteMapping("/{id}")
    public LessonResponse deleteById(@PathVariable Long id){
        return lessonService.deleteLessonById(id);
    }
}
