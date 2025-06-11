
package com.StableManagement.stable_management_api.services;

import com.StableManagement.stable_management_api.dto.UserDto;
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

    public User getUserById(Long id){
        User user = userRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Nie znaleziono użytkownika z id: " + id));

        if(user.getDeleted()){
            throw new NotFoundException("Ten użytkownik został usunięty");
        }

        return user;
    }

    public UserDto getUserDtoById(Long id){
        User user = userRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Nie znaleziono użytkownika z id: " + id));

        if(user.getDeleted()){
            throw new NotFoundException("Ten użytkownik został usunięty");
        }

        return mapper.entityToDto(user);
    }

    public List<UserDto> getUsers(){
        List<User> users = userRepository.findAll();
        return mapper.entitiesToDtos(users);
    }

    public UserDto patchUser(Long id, UserDto userDto){
        User user = userRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Nie znaleziono użytkownika z id: " + id));

        if(user.getDeleted()){
            throw new NotFoundException("Ten użytkownik został usunięty");
        }

        mapper.patchEntityFromDto(userDto, user);
        User patchedUser = userRepository.save(user);

        return mapper.entityToDto(patchedUser);
    }

    public void deleteUser(Long id){
        User user = userRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Nie znaleziono użytkownika z id: " + id));

        if(user.getDeleted()){
            throw new NotFoundException("użytkownik z id: " + id + ", został już usunięty");
        }

        user.setDeleted(true);
        userRepository.save(user);
    }
}