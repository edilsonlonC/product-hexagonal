package com.opencoders.products.infrastructure.database.ports.out;

import com.opencoders.products.infrastructure.database.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface UserJPARepository extends JpaRepository<UserEntity, Long> {
    @Query("SELECT u FROM UserEntity u where u.email = ?1")
    Optional<UserEntity> findByEmail (String email);
}
