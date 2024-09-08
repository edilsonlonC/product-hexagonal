package com.opencoders.products.infrastructure.database.ports.out;

import com.opencoders.products.infrastructure.database.entities.RolesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface RoleJPARepository extends JpaRepository<RolesEntity, Long> {
    Optional<RolesEntity> findById(Long id);
}
