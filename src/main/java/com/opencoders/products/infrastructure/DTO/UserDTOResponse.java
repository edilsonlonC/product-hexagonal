package com.opencoders.products.infrastructure.DTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class UserDTOResponse {
    private Long id;
    private String name;
    private String surname;
    private String email;
}
