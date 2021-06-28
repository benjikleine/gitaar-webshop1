package com.example.Gitaar.Webshop.repository;

import com.example.Gitaar.Webshop.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByActivationCode(String code);

    User findByEmail(String email);

    User findByPasswordResetCode(String code);
    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}
