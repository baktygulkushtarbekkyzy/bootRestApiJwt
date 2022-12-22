package com.example.bootrestapi.converter;

import com.example.bootrestapi.dto.user.UserRequest;
import com.example.bootrestapi.dto.user.UserResponse;
import com.example.bootrestapi.model.AuthInfo;
import com.example.bootrestapi.model.User;
import com.example.bootrestapi.repository.RoleRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserConverter {
    private final RoleRepository roleRepository;

    public UserConverter(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public User convertToEntity(Long id, UserRequest userRequest){
        if (userRequest==null){
            return null;
        }
        User user=new User();
        user.setId(id);
        user.setUsername(userRequest.getUserName());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());

        AuthInfo authInfo =new AuthInfo();
        authInfo.setEmail(userRequest.getEmail());
        authInfo.setPassword(user.getPassword());
        authInfo.addAuthInfo(roleRepository.getByName("STUDENT"));
        user.setAuthInfo(authInfo);
        return user;
    }

    public List<UserResponse> convertToResponse(List<User> users){
        List<UserResponse> responses=new ArrayList<>();
        for (User user:users) {
            responses.add(convertToResponse(user));
        }
        return responses;

    }
    public UserResponse convertToResponse(User user){
        if (user==null){
            return null;
        }
        UserResponse userResponse=new UserResponse();
        if (user.getId()!=null){
            userResponse.setId(user.getId());
        }
        userResponse.setUserName(user.getUsername());
        userResponse.setEmail(user.getEmail());
        return userResponse;
    }



}
