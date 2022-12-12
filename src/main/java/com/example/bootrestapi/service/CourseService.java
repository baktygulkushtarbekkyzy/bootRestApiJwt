package com.example.bootrestapi.service;

import com.example.bootrestapi.dto.course.CourseRequest;
import com.example.bootrestapi.dto.course.CourseResponse;
import com.example.bootrestapi.model.Course;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
@Service
public interface CourseService {

    CourseResponse saveCourse(Long companyId, CourseRequest courseRequest) throws IOException;

    CourseResponse updateCourse(Long id, CourseRequest courseRequest);

    CourseResponse getById(Long id);

    List<CourseResponse> getAllCourse();

    CourseResponse deleteCourseById(Long id);
}
