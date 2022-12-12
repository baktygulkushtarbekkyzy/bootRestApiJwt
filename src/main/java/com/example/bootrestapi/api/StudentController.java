package com.example.bootrestapi.api;

import com.example.bootrestapi.dto.lesson.LessonRequest;
import com.example.bootrestapi.dto.lesson.LessonResponse;
import com.example.bootrestapi.dto.student.StudentRequest;
import com.example.bootrestapi.dto.student.StudentResponse;
import com.example.bootrestapi.service.LessonService;
import com.example.bootrestapi.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public List<StudentResponse> getAll(){
        return studentService.getAllStudent();
    }

    @PostMapping("/save/{id}")
    public StudentResponse saveInstructor(@PathVariable Long id, @RequestBody StudentRequest studentRequest) throws IOException {
        return studentService.saveStudent(id,studentRequest);
    }

    @PostMapping("/{id}")
    public StudentResponse updateCourse(@PathVariable Long id, @RequestBody StudentRequest studentRequest){
        return studentService.updateStudent(id, studentRequest);
    }

    @GetMapping("/{id}")
    public StudentResponse getById(@PathVariable Long id){
        return studentService.getById(id);
    }

    @DeleteMapping("/{id}")
    public StudentResponse deleteById(@PathVariable Long id){
        return studentService.deleteStudentById(id);
    }
}
