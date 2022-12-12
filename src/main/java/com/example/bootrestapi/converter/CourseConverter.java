package com.example.bootrestapi.converter;

import com.example.bootrestapi.dto.company.CompanyResponse;
import com.example.bootrestapi.dto.course.CourseRequest;
import com.example.bootrestapi.dto.course.CourseResponse;
import com.example.bootrestapi.model.Course;
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
public class CourseConverter {

    public Course create(CourseRequest courseRequest){
        if (courseRequest==null){
            return null;
        }
        Course course =new Course();
        course.setCourseName(courseRequest.getCourseName());
        course.setDescription(courseRequest.getDescription());
        course.setDuration(courseRequest.getDuration());
        return course;
    }

    public CourseResponse convertToResponse(Course course){
        CourseResponse courseResponse =new CourseResponse(course.getId(), course.getCourseName(), course.getDuration(), course.getDescription());
        courseResponse.setCompanyId(course.getCompany().getId());
        return courseResponse;
    }

    public List<CourseResponse> view(List<Course> courses){
        List<CourseResponse> courseResponses=new ArrayList<>();
        for (Course c:courses) {
            courseResponses.add(convertToResponse(c));
        }
        return courseResponses;
    }
}
