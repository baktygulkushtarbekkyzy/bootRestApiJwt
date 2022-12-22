package com.example.bootrestapi.api;

import com.example.bootrestapi.dto.group.GroupRequest;
import com.example.bootrestapi.dto.group.GroupResponse;
import com.example.bootrestapi.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/groups")
@PreAuthorize("hasAuthority('ADMIN')")
public class GroupController {
    private final GroupService groupService;

    @GetMapping
    @PreAuthorize("permitAll()")
    public List<GroupResponse> getAll(){
        return groupService.getAllGroup();
    }

    @PostMapping
    public GroupResponse saveCompany(@RequestBody GroupRequest groupRequest) throws IOException {
        return groupService.saveGroup(groupRequest);
    }

    @PostMapping("/{id}")
    public GroupResponse updateCompany(@PathVariable Long id, @RequestBody GroupRequest groupRequest){
        return groupService.updateGroup(id, groupRequest);
    }

    @GetMapping("/{id}")
    @PreAuthorize("permitAll()")
    public GroupResponse getById(@PathVariable Long id){
        return groupService.getById(id);
    }

    @DeleteMapping("/{id}")
    public GroupResponse deleteById(@PathVariable Long id){
        return groupService.deleteGroupById(id);
    }

    @PostMapping("/assignCourse")
    public String  assignToCourse(@RequestParam Long groupId,@RequestParam Long courseId){
       return groupService.assignGroupToCourse(groupId, courseId);
    }

    @PostMapping("/assign")
    public String
    assignToStudent(@RequestParam Long groupId,@RequestParam Long studentId){
        return groupService.assignGroupToStudent(groupId, studentId);
    }
}
