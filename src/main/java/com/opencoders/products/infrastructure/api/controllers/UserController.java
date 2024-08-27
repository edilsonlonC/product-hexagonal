package com.opencoders.products.infrastructure.api.controllers;

import com.opencoders.products.application.products.usecases.UserUseCase;
import com.opencoders.products.infrastructure.DTO.UserDTOCreate;
import com.opencoders.products.infrastructure.DTO.UserDTOResponse;
import com.opencoders.products.infrastructure.mapper.UserDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserDTOMapper userDTOMapper;
    @Autowired
    private UserUseCase userUseCase;
    @PostMapping
    public ResponseEntity<UserDTOResponse> create ( @RequestBody  UserDTOCreate userDTOCreate) {
        return new ResponseEntity<>(
                userDTOMapper.userToUserDtoResponse(
                        userUseCase.create(userDTOMapper.userDtoCreateToUser(userDTOCreate))
                ),
                HttpStatus.CREATED
        );

    }
}
