package com.fiap.carcheap.controller.mapper;

import com.fiap.carcheap.controller.response.UserResponse;
import com.fiap.carcheap.repository.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserResponseMapper {
    UserResponse toUserResponse(User pedido);
}
