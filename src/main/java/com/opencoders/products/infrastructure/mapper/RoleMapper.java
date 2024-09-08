package com.opencoders.products.infrastructure.mapper;

import com.opencoders.products.domain.models.Roles;
import com.opencoders.products.infrastructure.database.entities.RolesEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    Roles roleEntityToRole (RolesEntity roleEntity);
    RolesEntity roleToRoleEntity(Roles role);
}
