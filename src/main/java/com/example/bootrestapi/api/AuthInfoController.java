package com.example.bootrestapi.api;

import com.example.bootrestapi.dto.auth.AuthInfoRequest;
import com.example.bootrestapi.dto.auth.AuthInfoResponse;
import com.example.bootrestapi.dto.user.UserRequest;
import com.example.bootrestapi.dto.user.UserResponse;
import com.example.bootrestapi.model.AuthInfo;
import com.example.bootrestapi.service.AuthInfoService;
import com.example.bootrestapi.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/authInfo")
public class AuthInfoController {

    private final AuthInfoService authInfoService;

    private final UserService userService;

    @PostMapping("/login")
    public AuthInfoResponse save(@RequestBody AuthInfoRequest authInfoRequest){
        return authInfoService.returnToken(authInfoRequest);
    }

    @PostMapping("/registration")
    public UserResponse registration(@RequestBody UserRequest userRequest){
        return  userService.registration(userRequest);
    }
}
