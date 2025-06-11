package com.StableManagement.stable_management_api.security;

import com.StableManagement.stable_management_api.repositories.HorseRepository;
import com.StableManagement.stable_management_api.repositories.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component("horseSecurity")
public class HorseSecurity {
    private final HorseRepository horseRepository;

    public HorseSecurity(HorseRepository horseRepository){
        this.horseRepository = horseRepository;
    }

    public boolean isOwner(Long horseId, Authentication auth){
        String username = auth.getName();
        return horseRepository.findById(horseId)
                .map(horse -> horse.getOwner().getUsername().equals(username))
                .orElse(false);
    }
}
