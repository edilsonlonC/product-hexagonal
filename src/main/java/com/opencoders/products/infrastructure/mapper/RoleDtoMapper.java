package com.opencoders.products.infrastructure.mapper;

import com.opencoders.products.domain.models.Roles;
import com.opencoders.products.infrastructure.DTO.RoleDtoResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleDtoMapper {
    Roles roleDtoResponseMapperToRole(RoleDtoResponse role);
    RoleDtoResponse roletoRoleDtoResponse(Roles role);

}
