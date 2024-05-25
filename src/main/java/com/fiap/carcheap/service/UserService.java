package com.fiap.carcheap.service;

import com.fiap.carcheap.controller.mapper.UserResponseMapper;
import com.fiap.carcheap.controller.request.UserRequest;
import com.fiap.carcheap.controller.response.UserResponse;
import com.fiap.carcheap.exception.UserNotFoundException;
import com.fiap.carcheap.exception.UsernameAlreadyExistsException;
import com.fiap.carcheap.repository.UserRepository;
import com.fiap.carcheap.repository.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class UserService {

    Logger logger = Logger.getLogger(UserService.class.getName());
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
        return getById(id)
                .map(userResponse::toUserResponse)
                .orElseThrow(UserNotFoundException::new);
    }

    public Optional<User> getById(Long id) {
        return repository.findById(id);
    }

    public UserResponse save(UserRequest request) {
        checkUsernameExists(request);
        return userResponse.toUserResponse(repository.save(UserRequest.toEntity(request)));
    }

    public void checkUsernameExists(UserRequest request) {
        repository.findByUsername(request.getUsername())
                .ifPresentOrElse(user -> {
                            throw new UsernameAlreadyExistsException();
                        },
                        () -> logger.info("username não existe, liberado para utilização"));
    }
}
