package com.example.bootrestapi.api;

import com.example.bootrestapi.dto.course.CourseRequest;
import com.example.bootrestapi.dto.course.CourseResponse;
import com.example.bootrestapi.dto.instructor.InstructorRequest;
import com.example.bootrestapi.dto.instructor.InstructorResponse;
import com.example.bootrestapi.service.CourseService;
import com.example.bootrestapi.service.InstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/instructors")
public class InstructorController {
    private final InstructorService instructorService;

    @GetMapping
    public List<InstructorResponse> getAll(){
        return instructorService.getAllInstructor();
    }

    @PostMapping("/save/{id}")
    public InstructorResponse saveInstructor(@PathVariable Long id, @RequestBody InstructorRequest instructorRequest) throws IOException {
        return instructorService.saveInstructor(id,instructorRequest);
    }

    @PostMapping("/{id}")
    public InstructorResponse updateCourse(@PathVariable Long id, @RequestBody InstructorRequest instructorRequest){
        return instructorService.updateInstructor(id, instructorRequest);
    }

    @GetMapping("/{id}")
    public InstructorResponse getById(@PathVariable Long id){
        return instructorService.getById(id);
    }

    @DeleteMapping("/{id}")
    public InstructorResponse deleteById(@PathVariable Long id){
        return instructorService.deleteInstructorById(id);
    }
}
