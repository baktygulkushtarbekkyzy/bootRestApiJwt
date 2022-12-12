package com.example.bootrestapi.converter;

import com.example.bootrestapi.dto.student.StudentRequest;
import com.example.bootrestapi.dto.student.StudentResponse;
import com.example.bootrestapi.model.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Component
public class StudentConverter {

    public Student create(StudentRequest studentRequest){
        if (studentRequest==null){
            return null;
        }
        Student student=new Student();
        student.setFirstName(studentRequest.getFirstName());
        student.setLastName(studentRequest.getLastName());
        student.setEmail(studentRequest.getEmail());
        student.setPhoneNumber(studentRequest.getPhoneNumber());
        student.setStudyFormat(studentRequest.getStudyFormat());
        return student;
    }

    public StudentResponse convertToResponse(Student student){
        return new StudentResponse(student.getId(), student.getFirstName(),student.getLastName(),student.getPhoneNumber(),student.getEmail(),student.getStudyFormat(),student.getGroup().getId());
    }

    public List<StudentResponse> view(List<Student> students){
        List<StudentResponse> studentResponses=new ArrayList<>();
        for (Student s:students) {
            studentResponses.add(convertToResponse(s));
        }
        return studentResponses;
    }
}

