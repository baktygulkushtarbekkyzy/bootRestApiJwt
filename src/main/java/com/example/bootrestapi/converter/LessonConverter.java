package com.example.bootrestapi.converter;

import com.example.bootrestapi.dto.lesson.LessonRequest;
import com.example.bootrestapi.dto.lesson.LessonResponse;
import com.example.bootrestapi.model.Lesson;
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
public class LessonConverter {

    public Lesson create (LessonRequest lessonRequest){
        if (lessonRequest==null){
            return null;
        }
        Lesson lesson = new Lesson();
        lesson.setLessonName(lessonRequest.getLessonName());
        return lesson;
    }

    public LessonResponse convertToResponse(Lesson lesson){
        return new LessonResponse(lesson.getId(), lesson.getLessonName(), lesson.getCourse().getId());
    }

    public List<LessonResponse> view(List<Lesson> lessons){
        List<LessonResponse> lessonResponses=new ArrayList<>();
        for (Lesson l:lessons) {
            lessonResponses.add(convertToResponse(l));
        }
        return lessonResponses;
    }
}
