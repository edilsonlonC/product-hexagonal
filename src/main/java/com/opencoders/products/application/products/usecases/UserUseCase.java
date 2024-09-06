package com.opencoders.products.application.products.usecases;

import com.opencoders.products.domain.models.User;
import com.opencoders.products.domain.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserUseCase {
    @Autowired
    private UserRepository userRepository;

    public User create (User user) {
        return userRepository.create(user);
    }

    public User findByEmail (String email) {
        return userRepository.findByEmail(email).orElseThrow();
    }
}
