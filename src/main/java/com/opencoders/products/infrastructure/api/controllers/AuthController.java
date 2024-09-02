package com.opencoders.products.infrastructure.api.controllers;

import com.opencoders.products.application.products.usecases.UserUseCase;
import com.opencoders.products.domain.models.User;
import com.opencoders.products.infrastructure.DTO.LoginDto;
import com.opencoders.products.infrastructure.api.authentication.JwtAuthentication;
import com.opencoders.products.infrastructure.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private JwtAuthentication jwtAuthentication;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserUseCase userUseCase;
    @Autowired
    private UserMapper userMapper;
    @PostMapping
    public ResponseEntity<String> login (@RequestBody LoginDto loginDto) {

        User user = userUseCase.findByEmail(loginDto.getEmail());
        if (!passwordEncoder.matches(loginDto.getPassword(), user.getPassword())) throw new ResponseStatusException( HttpStatus.FORBIDDEN, "denied");
        return new ResponseEntity<>(jwtAuthentication.buildToken(userMapper.userToUserEntity(user)), HttpStatus.OK);






    }
}
