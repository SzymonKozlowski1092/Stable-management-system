package com.StableManagement.stable_management_api.security;

import com.StableManagement.stable_management_api.repositories.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component("userSecurity")
public class UserSecurity {
    private final UserRepository userRepository;

    public UserSecurity(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public boolean isSelf(Long userId, Authentication auth){
        String username = auth.getName();
        return userRepository.findById(userId)
                .map(user -> user.getUsername().equals(username))
                .orElse(false);
    }
}
