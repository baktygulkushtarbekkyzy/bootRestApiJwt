package com.example.bootrestapi.service;

import com.example.bootrestapi.dto.group.GroupRequest;
import com.example.bootrestapi.dto.group.GroupResponse;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
@Service

public interface GroupService {

    GroupResponse saveGroup(GroupRequest groupRequest) throws IOException;

    GroupResponse updateGroup(Long id, GroupRequest groupRequest);

    GroupResponse getById(Long id);

    List<GroupResponse> getAllGroup();

    GroupResponse deleteGroupById(Long id);

    String  assignGroupToCourse(Long groupId,Long courseId);

    String assignGroupToStudent(Long groupId, Long studentId);

}
