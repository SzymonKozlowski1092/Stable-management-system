package com.StableManagement.stable_management_api.services;

import com.StableManagement.stable_management_api.enums.UserRole;
import com.StableManagement.stable_management_api.models.User;
import com.StableManagement.stable_management_api.repositories.UserRepository;

import java.util.List;

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
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