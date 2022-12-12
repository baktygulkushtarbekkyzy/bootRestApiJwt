package com.example.bootrestapi.serviceImpl;

import com.example.bootrestapi.converter.StudentConverter;
import com.example.bootrestapi.dto.student.StudentRequest;
import com.example.bootrestapi.dto.student.StudentResponse;
import com.example.bootrestapi.model.Group;
import com.example.bootrestapi.model.Student;
import com.example.bootrestapi.repository.GroupRepository;
import com.example.bootrestapi.repository.StudentRepository;
import com.example.bootrestapi.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    private final GroupRepository groupRepository;

    private final StudentConverter studentConverter;

    @Override
    public StudentResponse saveStudent(Long groupId, StudentRequest studentRequest) {
        Group group = groupRepository.findById(groupId).orElseThrow(
                () -> new RuntimeException("not found!!!")
        );
        Student student = studentConverter.create(studentRequest);
        group.addStudent(student);
        student.setGroup(group);

        studentRepository.save(student);
        return studentConverter.convertToResponse(student);
    }

    @Override
    public StudentResponse updateStudent(Long id, StudentRequest studentRequest) {
        Student student = studentRepository.findById(id).orElseThrow(
                () -> new RuntimeException("not found!!!")
        );
        student.setFirstName(studentRequest.getFirstName());
        student.setLastName(studentRequest.getLastName());
        student.setEmail(studentRequest.getEmail());
        student.setPhoneNumber(studentRequest.getPhoneNumber());
        student.setStudyFormat(studentRequest.getStudyFormat());
        studentRepository.save(student);
        return studentConverter.convertToResponse(student);
    }

    @Override
    public StudentResponse getById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(
                () -> new RuntimeException("not found!!!")
        );
        return studentConverter.convertToResponse(student);
    }

    @Override
    public List<StudentResponse> getAllStudent() {
        List<StudentResponse> studentResponses=new ArrayList<>();
        for (Student s:studentRepository.findAll()) {
            studentResponses.add(studentConverter.convertToResponse(s));
        }
        return studentResponses;
    }

    @Override
    public StudentResponse deleteStudentById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(
                () -> new RuntimeException("not found!!!")
        );
        studentRepository.delete(student);
        return studentConverter.convertToResponse(student);
    }
}
