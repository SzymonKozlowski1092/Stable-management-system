package com.StableManagement.stable_management_api.repositories;

import com.StableManagement.stable_management_api.models.Horse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HorseRepository extends JpaRepository<Horse, Long> {
}
