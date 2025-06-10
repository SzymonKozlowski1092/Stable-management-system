
package com.StableManagement.stable_management_api.services;

import com.StableManagement.stable_management_api.dto.UserDto;
import com.StableManagement.stable_management_api.enums.UserRole;
import com.StableManagement.stable_management_api.exceptions.NotFoundException;
import com.StableManagement.stable_management_api.mappers.UserMapper;
import com.StableManagement.stable_management_api.models.User;
import com.StableManagement.stable_management_api.repositories.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper mapper;

    public UserService(UserRepository userRepository, UserMapper mapper){
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    public UserDto getUserById(Long id){
        User user = userRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Nie znaleziono użytkownika z id: " + id));

        return mapper.entityToDto(user);
    }

    public UserDto patchUser(Long id, UserDto userDto){
        User user = userRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Nie znaleziono użytkownika z id: " + id));

        mapper.patchEntityFromDto(userDto, user);
        User patchedUser = userRepository.save(user);

        return mapper.entityToDto(patchedUser);
    }
}