package com.example.bootrestapi.serviceImpl;

import com.example.bootrestapi.converter.LessonConverter;
import com.example.bootrestapi.converter.TaskConverter;
import com.example.bootrestapi.dto.lesson.LessonRequest;
import com.example.bootrestapi.dto.lesson.LessonResponse;
import com.example.bootrestapi.model.Course;
import com.example.bootrestapi.model.Lesson;
import com.example.bootrestapi.repository.CourseRepository;
import com.example.bootrestapi.repository.LessonRepository;
import com.example.bootrestapi.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService {
    private final LessonRepository lessonRepository;

    private final CourseRepository courseRepository;

    private final LessonConverter lessonConverter;


    @Override
    public LessonResponse saveLesson(Long courseId, LessonRequest lessonRequest) {
  Course course = courseRepository.findById(courseId).orElseThrow(
                () -> new RuntimeException("not found")
        );
        Lesson lesson = lessonConverter.create(lessonRequest);
        course.addLesson(lesson);
        lesson.setCourse(course);
        lessonRepository.save(lesson);
        return lessonConverter.convertToResponse(lesson);
    }

    @Override
    public LessonResponse updateLesson(Long id, LessonRequest lessonRequest) {
        Lesson lesson = lessonRepository.findById(id).orElseThrow(() -> new RuntimeException("not found"));
        lesson.setLessonName(lessonRequest.getLessonName());
        lessonRepository.save(lesson);
        return lessonConverter.convertToResponse(lesson);
    }

    @Override
    public LessonResponse getById(Long id) {
        Lesson lesson = lessonRepository.findById(id).orElseThrow(
                () -> new RuntimeException("not found!!!")
        );
        return lessonConverter.convertToResponse(lesson);
    }

    @Override
    public List<LessonResponse> getAllLesson() {
        List<LessonResponse> lessonResponses=new ArrayList<>();
        for (Lesson l:lessonRepository.findAll()) {
            lessonResponses.add(lessonConverter.convertToResponse(l));
        }
        return lessonResponses;
    }

    @Override
    public LessonResponse deleteLessonById(Long id) {
        Lesson lesson = lessonRepository.findById(id).orElseThrow(
                () -> new RuntimeException("not found!!!")
        );
        lessonRepository.delete(lesson);
        return lessonConverter.convertToResponse(lesson);
    }
}
