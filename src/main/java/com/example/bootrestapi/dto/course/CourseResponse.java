package com.example.bootrestapi.dto.course;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CourseResponse {
    private Long id;

    private String courseName;
    private int duration;
    private String description;
    private Long companyId;

    public CourseResponse(Long id, String courseName, int duration, String description) {
        this.id = id;
        this.courseName = courseName;
        this.duration = duration;
        this.description = description;
    }
}
