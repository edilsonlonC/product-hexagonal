package com.opencoders.products.infrastructure.DTO;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class LoginResponseDto {
    private final String token;
}
