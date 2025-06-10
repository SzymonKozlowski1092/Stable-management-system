package com.StableManagement.stable_management_api.services;

import com.StableManagement.stable_management_api.enums.UserRole;
import com.StableManagement.stable_management_api.exceptions.NotFoundException;
import com.StableManagement.stable_management_api.models.User;
import com.StableManagement.stable_management_api.repositories.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User getUserById(Long id){
        return userRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Nie znaleziono użytkownika z id: " + id));
    }
    public List<User> getAllEmployees(){
        return userRepository.findByRole(UserRole.EMPLOYEE);
    }
    public List<User> getAllBoarders(){
        return userRepository.findByRole(UserRole.BOARDER);
    }
    public List<User> getAllManagers(){
        return userRepository.findByRole(UserRole.MANAGER);
    }
}