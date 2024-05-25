package com.fiap.carcheap.service;

import com.fiap.carcheap.controller.mapper.UserResponseMapper;
import com.fiap.carcheap.controller.request.UserRequest;
import com.fiap.carcheap.controller.response.UserResponse;
import com.fiap.carcheap.exception.UserNotFoundException;
import com.fiap.carcheap.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;
    private final UserResponseMapper userResponse;

    public UserService(UserRepository repository, UserResponseMapper userResponse) {
        this.repository = repository;
        this.userResponse = userResponse;
    }
    public List<UserResponse> findAll() {
        return repository.findAll().stream()
                .map(userResponse::toUserResponse)
                .toList();
    }
    public UserResponse findById(Long id) {
        return repository.findById(id).map(userResponse::toUserResponse).orElseThrow(UserNotFoundException::new);
    }
    public UserResponse save(UserRequest request) {
        return userResponse.toUserResponse(repository.save(UserRequest.toEntity(request)));
    }



}
