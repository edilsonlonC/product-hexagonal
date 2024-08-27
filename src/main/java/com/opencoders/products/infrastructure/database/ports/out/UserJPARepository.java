package com.opencoders.products.infrastructure.database.ports.out;

import com.opencoders.products.infrastructure.database.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserJPARepository extends JpaRepository<UserEntity, Long> {
}
