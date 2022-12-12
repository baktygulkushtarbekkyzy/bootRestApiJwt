package com.example.bootrestapi.service;

import com.example.bootrestapi.dto.lesson.LessonRequest;
import com.example.bootrestapi.dto.lesson.LessonResponse;
import com.example.bootrestapi.model.Lesson;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface LessonService {
    LessonResponse saveLesson(Long courseId, LessonRequest lessonRequest);

    LessonResponse updateLesson(Long id,LessonRequest lessonRequest);

    LessonResponse getById(Long id);

    List<LessonResponse> getAllLesson();

    LessonResponse deleteLessonById(Long id);
}
