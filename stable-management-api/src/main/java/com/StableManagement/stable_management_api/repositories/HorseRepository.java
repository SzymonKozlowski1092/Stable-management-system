package com.StableManagement.stable_management_api.repositories;

import com.StableManagement.stable_management_api.models.Horse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HorseRepository extends JpaRepository<Horse, Long> {
    List<Horse> findByOwner_Id(Long ownerId);
}
