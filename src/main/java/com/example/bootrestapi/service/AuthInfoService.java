package com.example.bootrestapi.service;

import com.example.bootrestapi.dto.auth.AuthInfoRequest;
import com.example.bootrestapi.dto.auth.AuthInfoResponse;
import org.springframework.stereotype.Service;

@Service
public interface AuthInfoService {
    AuthInfoResponse returnToken(AuthInfoRequest authInfoRequest);
}
