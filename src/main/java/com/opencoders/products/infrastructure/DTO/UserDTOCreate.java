package com.opencoders.products.infrastructure.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.aot.hint.annotation.RegisterReflectionForBinding;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class UserDTOCreate {
   private String name;
   private String surname;
   private String email;
   private String password;
}
