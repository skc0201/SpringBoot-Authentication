package com.spring.authentication.authentication.repository;

import com.spring.authentication.authentication.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByEmail(String email);
    Optional<User> findOneByEmailAndPassword(String email, String password);

}
