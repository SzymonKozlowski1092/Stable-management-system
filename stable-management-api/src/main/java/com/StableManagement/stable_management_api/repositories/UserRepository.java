package com.StableManagement.stable_management_api.repositories;

import com.StableManagement.stable_management_api.enums.UserRole;
import com.StableManagement.stable_management_api.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findByPhoneNumber(String phoneNumber);
    List<User> findByRole(UserRole role);
}
