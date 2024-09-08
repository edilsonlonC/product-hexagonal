package com.opencoders.products.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class User {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private ArrayList<Roles> roles;
}
