package com.opencoders.products.domain.repositories;

import com.opencoders.products.domain.models.User;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface UserRepository {
    User create (User user);
    Optional<User>  findByEmail (String email);
}
