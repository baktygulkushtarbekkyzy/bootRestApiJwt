package com.example.bootrestapi.dto.lesson;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LessonResponse {
    private Long id;
    private String lessonName;

    private Long courseId;
}
