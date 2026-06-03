package com.jr.consentimiento.module.users.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.jr.consentimiento.module.users.entity.User;

public interface UserReposotory extends JpaRepository<User, Long> {

    boolean existsByEmail(String email);

    Optional<User> findByEmail(String email);
}
