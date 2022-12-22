package com.example.bootrestapi.dto.auth;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AuthInfoResponse {

    private String email;

    private String token;

    private String role;

}
