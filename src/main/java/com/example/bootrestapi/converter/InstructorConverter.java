package com.example.bootrestapi.converter;

import com.example.bootrestapi.dto.instructor.InstructorRequest;
import com.example.bootrestapi.dto.instructor.InstructorResponse;
import com.example.bootrestapi.model.Instructor;
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
public class InstructorConverter {

    public Instructor create(InstructorRequest instructorRequest){
        if (instructorRequest==null){
            return null;
        }
        Instructor instructor=new Instructor();
        instructor.setFirstName(instructorRequest.getFirstName());
        instructor.setLastName(instructorRequest.getLastName());
        instructor.setEmail(instructorRequest.getEmail());
        instructor.setPhoneNumber(instructorRequest.getPhoneNumber());
        instructor.setSpecialization(instructorRequest.getSpecialization());
        return instructor;
    }

    public InstructorResponse convertToResponse(Instructor instructor){
        return new InstructorResponse(instructor.getId(), instructor.getFirstName(),instructor.getLastName(),instructor.getPhoneNumber(),
                instructor.getEmail(),instructor.getSpecialization(),instructor.getCourse().getId());
    }

    public List<InstructorResponse> view(List<Instructor> instructors){
        List<InstructorResponse> instructorResponses=new ArrayList<>();
        for (Instructor i:instructors) {
            instructorResponses.add(convertToResponse(i));
        }
        return instructorResponses;
    }

}
