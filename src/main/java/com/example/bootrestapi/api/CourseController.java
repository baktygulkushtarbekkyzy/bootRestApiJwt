package com.example.bootrestapi.api;

import com.example.bootrestapi.dto.company.CompanyRequest;
import com.example.bootrestapi.dto.company.CompanyResponse;
import com.example.bootrestapi.dto.course.CourseRequest;
import com.example.bootrestapi.dto.course.CourseResponse;
import com.example.bootrestapi.service.CompanyService;
import com.example.bootrestapi.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/courses")
public class CourseController {
    private final CompanyService companyService;

    private final CourseService courseService;

    @GetMapping
    public List<CourseResponse> getAll(){
        return courseService.getAllCourse();
    }

    @PostMapping("/save/{id}")
    public CourseResponse saveCourse(@PathVariable Long id,@RequestBody CourseRequest courseRequest) throws IOException {
        return courseService.saveCourse(id,courseRequest);
    }

    @PostMapping("/{id}")
    public CourseResponse updateCourse(@PathVariable Long id, @RequestBody CourseRequest courseRequest){
        return courseService.updateCourse(id, courseRequest);
    }

    @GetMapping("/{id}")
    public CourseResponse getById(@PathVariable Long id){
        return courseService.getById(id);
    }

    @DeleteMapping("/{id}")
    public CourseResponse deleteById(@PathVariable Long id){
        return courseService.deleteCourseById(id);
    }
}
