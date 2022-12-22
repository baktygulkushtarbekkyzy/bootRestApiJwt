package com.example.bootrestapi.service;

import com.example.bootrestapi.dto.user.UserRequest;
import com.example.bootrestapi.dto.user.UserResponse;
import com.example.bootrestapi.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    List<UserResponse> findAll();

    UserResponse registration(UserRequest userRequest);

    Optional<User> findById(Long id);

    UserResponse deleteById(Long id);

    UserResponse update(Long id,UserRequest userRequest);


}
