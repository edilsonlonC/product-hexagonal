package com.opencoders.products.infrastructure.api.controllers;

import com.opencoders.products.application.products.usecases.UserUseCase;
import com.opencoders.products.domain.models.User;
import com.opencoders.products.infrastructure.DTO.LoginDto;
import com.opencoders.products.infrastructure.DTO.LoginResponseDto;
import com.opencoders.products.infrastructure.api.authentication.JwtAuthentication;
import com.opencoders.products.infrastructure.mapper.UserMapper;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class AuthController {
    private final JwtAuthentication jwtAuthentication;
    private final PasswordEncoder passwordEncoder;
    private final UserUseCase userUseCase;
    private final UserMapper userMapper;
    @PostMapping()
    public ResponseEntity<LoginResponseDto> login (@RequestBody LoginDto loginDto) {
        User user = userUseCase.findByEmail(loginDto.getEmail());
        if (!passwordEncoder.matches(loginDto.getPassword(), user.getPassword())) throw new ResponseStatusException( HttpStatus.FORBIDDEN, "denied");
        LoginResponseDto loginResponseDto = new LoginResponseDto(jwtAuthentication.buildToken(userMapper.userToUserEntity(user)));
        return new ResponseEntity<>(loginResponseDto, HttpStatus.OK);
    }
}
