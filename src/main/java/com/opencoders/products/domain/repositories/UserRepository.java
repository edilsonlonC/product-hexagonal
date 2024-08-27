package com.opencoders.products.domain.repositories;

import com.opencoders.products.domain.models.User;
import org.springframework.stereotype.Component;

@Component
public interface UserRepository {
    User create (User user);
}
