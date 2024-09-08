package com.opencoders.products.infrastructure.mapper;

import com.opencoders.products.domain.models.User;
import com.opencoders.products.infrastructure.DTO.UserDTOCreate;
import com.opencoders.products.infrastructure.DTO.UserDTOResponse;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper( componentModel = "spring",
        uses=RoleDtoMapper.class

)

public interface UserDTOMapper {
    UserDTOMapper INSTANCE = Mappers.getMapper(UserDTOMapper.class);
    User userDtoCreateToUser (UserDTOCreate userDTOCreate);
    UserDTOResponse userToUserDtoResponse(User user);

}
