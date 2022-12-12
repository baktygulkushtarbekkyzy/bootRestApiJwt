package com.example.bootrestapi.serviceImpl;

import com.example.bootrestapi.converter.GroupConverter;
import com.example.bootrestapi.dto.group.GroupRequest;
import com.example.bootrestapi.dto.group.GroupResponse;
import com.example.bootrestapi.model.Course;
import com.example.bootrestapi.model.Group;
import com.example.bootrestapi.model.Student;
import com.example.bootrestapi.repository.CourseRepository;
import com.example.bootrestapi.repository.GroupRepository;
import com.example.bootrestapi.repository.StudentRepository;
import com.example.bootrestapi.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {
    private final GroupRepository groupRepository;

    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;

    private final GroupConverter groupConverter;


    @Override
    public GroupResponse saveGroup( GroupRequest groupRequest) throws IOException {
        Group group=groupConverter.create(groupRequest);
        groupRepository.save(group);
        return groupConverter.convertToResponse(group);
    }

    @Override
    public GroupResponse updateGroup(Long id, GroupRequest groupRequest) {
        Group group = groupRepository.findById(id).orElseThrow(() -> new RuntimeException("not found"));
        group.setGroupName(groupRequest.getGroupName());
        group.setDateOfStart(groupRequest.getDateOfStart());
        group.setImage(groupRequest.getImage());
        groupRepository.save(group);
        return groupConverter.convertToResponse(group);
    }

    @Override
    public GroupResponse getById(Long id) {
        Group group = groupRepository.findById(id).orElseThrow(
                () -> new RuntimeException("not found!!!")
        );
        return groupConverter.convertToResponse(group);
    }

    @Override
    public List<GroupResponse> getAllGroup() {
        return groupConverter.view(groupRepository.findAll());
    }

    @Override
    public GroupResponse deleteGroupById(Long id) {
        Group group = groupRepository.findById(id).orElseThrow(
                () -> new RuntimeException("not found!!!"));
        groupRepository.delete(group);
        return groupConverter.convertToResponse(group);
    }

    @Override
    public String assignGroupToCourse(Long groupId, Long courseId) {
        Group group = groupRepository.findById(groupId).orElseThrow(
                () -> new RuntimeException("not found!!!")
        );
        Course course = courseRepository.findById(courseId).orElseThrow(
                () -> new RuntimeException("not found!!!")
        );

        List<Group> groups = new ArrayList<>();
        groups.add(group);

        List<Course> courses = new ArrayList<>();
        courses.add(course);

        group.setCourses(courses);
        course.setGroups(groups);

        groupRepository.save(group);
        return "Assign group to course was successfully!";
    }

    @Override
    public String assignGroupToStudent(Long groupId, Long studentId) {
        Group group = groupRepository.findById(groupId).orElseThrow(
                () -> new RuntimeException("not found!!!")
        );
        Student student  = studentRepository.findById(studentId).orElseThrow(
                () -> new RuntimeException("not found!!!")
        );
        List<Student> students = new ArrayList<>();
        students.add(student);

        group.setStudents(students);
        student.setGroup(group);

        groupRepository.save(group);
        return "Assign group to student was successfully!";
    }
}
