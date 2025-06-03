package com.StableManagement.stable_management_api.repositories;

import com.StableManagement.stable_management_api.models.RegistrationCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RegistrationCodeRepository extends JpaRepository<RegistrationCode, Long> {
    Optional<RegistrationCode> findByCode(int code);
    boolean existsByCode(int code);
}