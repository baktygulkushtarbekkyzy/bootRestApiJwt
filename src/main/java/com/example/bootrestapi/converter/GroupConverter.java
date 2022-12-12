package com.example.bootrestapi.converter;

import com.example.bootrestapi.dto.group.GroupRequest;
import com.example.bootrestapi.dto.group.GroupResponse;
import com.example.bootrestapi.model.Group;
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
public class GroupConverter {

    public Group create(GroupRequest groupRequest){
        if (groupRequest==null){
            return  null;
        }
        Group group=new Group();
        group.setGroupName(groupRequest.getGroupName());
        group.setDateOfStart(groupRequest.getDateOfStart());
        group.setImage(groupRequest.getImage());
        return group;
    }

    public GroupResponse convertToResponse(Group group){
        return new GroupResponse(group.getId(),group.getGroupName(),group.getDateOfStart(), group.getImage());
    }

    public List<GroupResponse> view(List<Group> groups){
        List<GroupResponse> groupResponses=new ArrayList<>();
        for (Group g:groups) {
            groupResponses.add(convertToResponse(g));
        }
        return groupResponses;
    }
}

