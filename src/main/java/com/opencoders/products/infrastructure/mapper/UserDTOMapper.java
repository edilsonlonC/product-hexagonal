package com.opencoders.products.infrastructure.mapper;

import com.opencoders.products.domain.models.User;
import com.opencoders.products.infrastructure.DTO.UserDTOCreate;
import com.opencoders.products.infrastructure.DTO.UserDTOResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserDTOMapper {
    UserDTOMapper INSTANCE = Mappers.getMapper(UserDTOMapper.class);
    User userDtoCreateToUser (UserDTOCreate userDTOCreate);
    UserDTOResponse userToUserDtoResponse(User user);
}
