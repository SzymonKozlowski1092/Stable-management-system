package com.StableManagement.stable_management_api.mappers;

import com.StableManagement.stable_management_api.dto.horse.HorseDto;
import com.StableManagement.stable_management_api.models.Horse;
import com.StableManagement.stable_management_api.models.User;
import com.StableManagement.stable_management_api.services.UserService;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HorseMapper {
    @Mapping(source = "owner.id", target = "ownerId")
    HorseDto entityToDto(Horse horse);

    @Mapping(source = "ownerId", target = "owner", qualifiedByName = "ownerIdToOwner")
    @Mapping(target = "id", ignore = true)
    Horse dtoToEntity(HorseDto horseDto, @Context UserService userService);

    @Named("ownerIdToOwner")
    default User ownerIdToOwner(Long ownerId, @Context UserService userService){
        if(ownerId == null) {
            return null;
        }

        return userService.getUserById(ownerId);
    }

    List<HorseDto> entitiesToDtos(List<Horse> horses);
    List<Horse> dtosToEntities(List<HorseDto> horseDtos, @Context UserService userService);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "ownerId", target = "owner", qualifiedByName = "ownerIdToOwner")
    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(HorseDto dto, @MappingTarget Horse horse, @Context UserService userService);
}
