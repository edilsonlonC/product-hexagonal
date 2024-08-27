package com.opencoders.products.infrastructure.database.ports.out.repositories;

import com.opencoders.products.domain.models.User;
import com.opencoders.products.domain.repositories.UserRepository;
import com.opencoders.products.infrastructure.database.ports.out.UserJPARepository;
import com.opencoders.products.infrastructure.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserRepositoryImpl implements UserRepository {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserJPARepository userJPARepository;
    @Override
    public User create(User user) {
        return userMapper.userEntityToUser(
                userJPARepository.save(userMapper.userToUserEntity(user)
                ));
    }
}
