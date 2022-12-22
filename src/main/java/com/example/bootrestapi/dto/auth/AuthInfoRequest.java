package com.example.bootrestapi.dto.auth;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthInfoRequest {

    private String email;

    private String password;
}
