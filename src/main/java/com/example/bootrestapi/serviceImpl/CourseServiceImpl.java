package com.example.bootrestapi.serviceImpl;

import com.example.bootrestapi.converter.CourseConverter;
import com.example.bootrestapi.dto.course.CourseRequest;
import com.example.bootrestapi.dto.course.CourseResponse;
import com.example.bootrestapi.model.Company;
import com.example.bootrestapi.model.Course;
import com.example.bootrestapi.repository.CompanyRepository;
import com.example.bootrestapi.repository.CourseRepository;
import com.example.bootrestapi.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;

    private final CompanyRepository companyRepository;

    private final CourseConverter courseConverter;

    @Override
    public CourseResponse saveCourse(Long companyId, CourseRequest courseRequest) throws IOException {
        Company company=companyRepository.findById(companyId).orElseThrow(()->new RuntimeException("not found"));
        Course course=courseConverter.create(courseRequest);
        company.addCourse(course);
        course.setCompany(company);
        courseRepository.save(course);
        return courseConverter.convertToResponse(course);
    }

    @Override
    public CourseResponse updateCourse(Long id, CourseRequest courseRequest) {
        Course course=courseRepository.findById(id).orElseThrow(()->new RuntimeException("not found"));
        course.setCourseName(courseRequest.getCourseName());
        course.setDuration(courseRequest.getDuration());
        course.setDescription(courseRequest.getDescription());
        courseRepository.save(course);
        return  courseConverter.convertToResponse(course);
    }

    @Override
    public CourseResponse getById(Long id) {
        Course course=courseRepository.findById(id).orElseThrow(()->new RuntimeException("not found"));
        return courseConverter.convertToResponse(course);
    }

    @Override
    public List<CourseResponse> getAllCourse() {
        List<CourseResponse> courseResponses=new ArrayList<>();
        for (Course c :courseRepository.findAll()) {
            courseResponses.add(courseConverter.convertToResponse(c));
        }
        return courseResponses;
    }

    @Override
    public CourseResponse deleteCourseById(Long id) {
        Course course=courseRepository.findById(id).orElseThrow(()->new RuntimeException("not found"));
        courseRepository.delete(course);
        return courseConverter.convertToResponse(course);
    }
}
