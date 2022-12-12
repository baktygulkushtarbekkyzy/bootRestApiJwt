package com.example.bootrestapi.service;

import com.example.bootrestapi.dto.instructor.InstructorRequest;
import com.example.bootrestapi.dto.instructor.InstructorResponse;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface InstructorService {
    InstructorResponse saveInstructor(Long courseId, InstructorRequest instructorRequest);

    InstructorResponse updateInstructor(Long id, InstructorRequest instructorRequest);

    InstructorResponse getById(Long id);

    List<InstructorResponse> getAllInstructor();

    InstructorResponse deleteInstructorById(Long id);

}
