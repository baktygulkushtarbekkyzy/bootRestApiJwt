package com.example.bootrestapi.dto.course;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CourseRequest {

    private String courseName;
    private int duration;
    private String description;
    private Long companyId;
}
