package com.example.bootrestapi.serviceImpl;

import com.example.bootrestapi.converter.InstructorConverter;
import com.example.bootrestapi.dto.instructor.InstructorRequest;
import com.example.bootrestapi.dto.instructor.InstructorResponse;
import com.example.bootrestapi.model.Course;
import com.example.bootrestapi.model.Instructor;
import com.example.bootrestapi.repository.CourseRepository;
import com.example.bootrestapi.repository.InstructorRepository;
import com.example.bootrestapi.service.InstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class InstructorServiceImpl implements InstructorService {

    private final InstructorRepository instructorRepository;

    private final CourseRepository courseRepository;

    private final InstructorConverter instructorConverter;


    @Override
    public InstructorResponse saveInstructor(Long courseId, InstructorRequest instructorRequest) {
        Course course = courseRepository.findById(courseId).orElseThrow(
                () -> new RuntimeException("not found")
        );
        Instructor instructor = instructorConverter.create(instructorRequest);
        course.addInstructor(instructor);
        instructor.setCourse(course);
        instructorRepository.save(instructor);
        return instructorConverter.convertToResponse(instructor);
    }

    @Override
    public InstructorResponse updateInstructor(Long id, InstructorRequest instructorRequest) {
        Instructor instructor = instructorRepository.findById(id).orElseThrow(() -> new RuntimeException("not found"));
        instructor.setFirstName(instructorRequest.getFirstName());
        instructor.setLastName(instructorRequest.getLastName());
        instructor.setEmail(instructorRequest.getEmail());
        instructor.setPhoneNumber(instructorRequest.getPhoneNumber());
        instructor.setSpecialization(instructorRequest.getSpecialization());
        instructorRepository.save(instructor);
        return instructorConverter.convertToResponse(instructor);
    }

    @Override
    public InstructorResponse getById(Long id) {

        Instructor instructor = instructorRepository.findById(id).orElseThrow(
                () -> new RuntimeException("not found")
        );
        return instructorConverter.convertToResponse(instructor);
    }

    @Override
    public List<InstructorResponse> getAllInstructor() {
        List<InstructorResponse> instructorResponses=new ArrayList<>();
        for (Instructor i:instructorRepository.findAll()) {
            instructorResponses.add(instructorConverter.convertToResponse(i));
        }
        return instructorResponses;
    }

    @Override
    public InstructorResponse deleteInstructorById(Long id) {
        Instructor instructor = instructorRepository.findById(id).orElseThrow(
                () -> new RuntimeException("not found")
        );
        instructorRepository.delete(instructor);
        return instructorConverter.convertToResponse(instructor);
    }

}
