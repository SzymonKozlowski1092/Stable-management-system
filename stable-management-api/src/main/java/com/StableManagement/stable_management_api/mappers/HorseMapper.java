package com.StableManagement.stable_management_api.mappers;

import com.StableManagement.stable_management_api.dto.horse.HorseDto;
import com.StableManagement.stable_management_api.models.Horse;
import com.StableManagement.stable_management_api.models.User;
import com.StableManagement.stable_management_api.services.UserService;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import java.util.List;

@Mapper
public interface HorseMapper {
    @Mapping(source = "owner.id", target = "ownerId")
    HorseDto entityToDto(Horse horse);

    @Mapping(source = "ownerId", target = "owner", qualifiedByName = "ownerIdToOwner")
    Horse dtoToEntity(HorseDto horseDto);

    @Named("ownerIdToOwner")
    default User ownerIdToOwner(Long ownerId, @Context UserService userService){
        if(ownerId == null) {
            return null;
        }

        return userService.getUserById(ownerId);
    }

    List<HorseDto> entitiesToDtos(List<Horse> horses);
    List<Horse> dtosToEntities(List<HorseDto> horseDtos, @Context UserService userService);
}
