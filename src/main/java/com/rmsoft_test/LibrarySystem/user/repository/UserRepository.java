package com.rmsoft_test.LibrarySystem.user.repository;

import com.rmsoft_test.LibrarySystem.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findById(String id);
}
