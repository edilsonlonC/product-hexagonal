package com.opencoders.products.infrastructure.mapper;

import com.opencoders.products.domain.models.User;
import com.opencoders.products.infrastructure.database.entities.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = RoleMapper.class)
public interface UserMapper {
    User userEntityToUser(UserEntity userEntity);
    UserEntity userToUserEntity(User user);
}
