package com.example.bootrestapi.serviceImpl;

import com.example.bootrestapi.converter.UserConverter;
import com.example.bootrestapi.dto.user.UserRequest;
import com.example.bootrestapi.dto.user.UserResponse;
import com.example.bootrestapi.model.User;
import com.example.bootrestapi.repository.UserRepository;
import com.example.bootrestapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserConverter userConverter;
    private final PasswordEncoder passwordEncoder;


    @Override
    public List<UserResponse> findAll() {
        return userConverter.convertToResponse(userRepository.findAll());
    }

    @Override
    public UserResponse registration(UserRequest userRequest) {
      String encodedPassword= passwordEncoder.encode(userRequest.getPassword());
      userRequest.setPassword(encodedPassword);

      User user =userConverter.convertToEntity(null,userRequest);
      User user1=userRepository.save(user);
        return userConverter.convertToResponse(user1);
    }

    @Override
    public Optional<User> findById(Long id) {
       boolean exists=userRepository.existsById(id);
       if (!exists){
           throw new RuntimeException(String.format("%d not",id));
       }
       return userRepository.findById(id);
    }

    @Override
    public UserResponse deleteById(Long id) {
        UserResponse userResponse=getById(id);
        boolean exists=userRepository.existsById(id);
        if (!exists){
            throw new RuntimeException(
                    String.format("%s exists",id)
            );
        }
        userRepository.deleteById(id);
        return userResponse;
    }

    private UserResponse getById(Long id) {
        return userConverter.convertToResponse(userRepository.findById(id).orElseThrow(()->new RuntimeException(
                String.format("%s exists ",id)
        )));
    }

    @Override
    public UserResponse update(Long id, UserRequest userRequest) {
        boolean exists=userRepository.existsById(id);
        User response;
        if (!exists){
            throw  new RuntimeException(
                    String.format(("%d exists")));
        }else {
            String encodedPassword= passwordEncoder.encode(userRequest.getPassword());
            userRequest.setPassword(encodedPassword);

            response=userConverter.convertToEntity(id,userRequest);
            userRepository.save(response);
        }


        return userConverter.convertToResponse(response);
    }

}
