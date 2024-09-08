package com.opencoders.products.infrastructure.database.ports.out.repositories;

import com.opencoders.products.domain.models.User;
import com.opencoders.products.domain.repositories.UserRepository;
import com.opencoders.products.infrastructure.database.entities.RolesEntity;
import com.opencoders.products.infrastructure.database.entities.UserEntity;
import com.opencoders.products.infrastructure.database.ports.out.RoleJPARepository;
import com.opencoders.products.infrastructure.database.ports.out.UserJPARepository;
import com.opencoders.products.infrastructure.mapper.RoleMapper;
import com.opencoders.products.infrastructure.mapper.UserMapper;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.management.relation.Role;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {
    private final UserMapper userMapper;
    private final UserJPARepository userJPARepository;
    private final RoleJPARepository roleJPARepository;
    @Override
    public User create(User user) {
        return userMapper.userEntityToUser(
                userJPARepository.save(userMapper.userToUserEntity(user)
                ));
    }

    @Override
    public Optional<User> findByEmail(String email) {
        Optional<UserEntity> resultUserEntity = userJPARepository.findByEmail(email);
        return resultUserEntity.isPresent() ?
                Optional.of(userMapper.userEntityToUser(resultUserEntity.get())) :
                Optional.empty();
    }

    @Override
    public Optional<User> addRole(Long roleId , String email) {
        try {

        Optional<UserEntity> resultUserEntity = userJPARepository.findByEmail(email);
        Optional<RolesEntity> resultRoleEntity = roleJPARepository.findById(roleId);
        UserEntity userEntity = resultUserEntity.get();
        userEntity.getRoles().add(resultRoleEntity.get());
        userJPARepository.save(userEntity);
        User user = userMapper.userEntityToUser(userEntity);
        return Optional.of(user);
    }catch(Exception ex){
            System.out.println(ex);
            return null;
        }
    }

}
