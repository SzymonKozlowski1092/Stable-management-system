package com.StableManagement.stable_management_api.mappers;

import com.StableManagement.stable_management_api.dto.UserDto;
import com.StableManagement.stable_management_api.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.lang.annotation.Target;
import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User dtoToEntity(UserDto userDto);
    UserDto entityToDto(User user);

    List<User> dtosToEntities(List<UserDto> userDtos);
    List<UserDto> entitiesToDtos(List<User> users);

    void patchEntityFromDto(UserDto userDto, @MappingTarget User user);
}
