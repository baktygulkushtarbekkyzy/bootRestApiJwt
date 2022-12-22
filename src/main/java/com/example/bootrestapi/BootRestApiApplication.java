package com.example.bootrestapi;

import com.example.bootrestapi.model.AuthInfo;
import com.example.bootrestapi.model.Role;
import com.example.bootrestapi.model.User;
import com.example.bootrestapi.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@SpringBootApplication
@RestController
@AllArgsConstructor
public class BootRestApiApplication {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(BootRestApiApplication.class, args);
    }
    @PostConstruct
    public void init() {
        User user = new User();
        user.setUsername("Admin");
        user.setEmail("admin@gmail.com");
        user.setPassword(passwordEncoder.encode("admin"));


        Role role = new Role();
        Role role1 = new Role();
        role.setName("ADMIN");
        role1.setName("STUDENT");

        AuthInfo authInfo = new AuthInfo();
        authInfo.setEmail(user.getEmail());
        authInfo.setPassword(user.getPassword());


        authInfo.addAuthInfo(role);
        authInfo.addAuthInfo(role1);

        user.setAuthInfo(authInfo);
        userRepository.save(user);

    }
}
