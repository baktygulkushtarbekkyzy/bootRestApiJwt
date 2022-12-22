package com.example.bootrestapi.api;

import com.example.bootrestapi.dto.user.UserRequest;
import com.example.bootrestapi.dto.user.UserResponse;
import com.example.bootrestapi.model.User;
import com.example.bootrestapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/user")
@PreAuthorize("hasAuthority('ADMIN')")
public class UserController {

    private final UserService userService;

    @GetMapping
    @PreAuthorize("permitAll()")
    public List<UserResponse> findAll(){
        return userService.findAll();
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable("id")Long id){
        userService.deleteById(id);
    }

    @GetMapping("{id}")
    @PreAuthorize("permitAll()")
    public Optional<User> findById(@PathVariable Long id){
        return userService.findById(id);
    }

    @PutMapping("{id}")
    public UserResponse update(@PathVariable Long id, @RequestBody UserRequest userRequest){
        return userService.update(id,userRequest);
    }
}
