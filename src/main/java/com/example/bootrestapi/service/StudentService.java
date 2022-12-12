package com.example.bootrestapi.service;

import com.example.bootrestapi.dto.student.StudentRequest;
import com.example.bootrestapi.dto.student.StudentResponse;
import com.example.bootrestapi.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface StudentService {

    StudentResponse saveStudent(Long groupId, StudentRequest studentRequest);

    StudentResponse updateStudent(Long id,StudentRequest studentRequest);

    StudentResponse getById(Long id);

    List<StudentResponse> getAllStudent();

    StudentResponse deleteStudentById(Long id);



}
