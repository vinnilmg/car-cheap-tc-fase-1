package com.fiap.carcheap.controller;

import com.fiap.carcheap.controller.request.UserRequest;
import com.fiap.carcheap.controller.response.UserResponse;
import com.fiap.carcheap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/users")
@RestController
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<UserResponse>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> findById(@PathVariable String id) {
        return ResponseEntity.ok(service.findById(id));
    }
    @PostMapping("/cadastrar")
    public ResponseEntity<UserResponse> save(@RequestBody UserRequest user ) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.save(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> update(@PathVariable String id ,@RequestBody UserRequest user ) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.update(id,user));
    }
}
