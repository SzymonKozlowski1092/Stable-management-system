package com.StableManagement.stable_management_api.mappers;

import com.StableManagement.stable_management_api.dto.note.NoteDto;
import com.StableManagement.stable_management_api.dto.note.NotePatchDto;
import com.StableManagement.stable_management_api.models.Horse;
import com.StableManagement.stable_management_api.models.Note;
import com.StableManagement.stable_management_api.models.User;
import com.StableManagement.stable_management_api.services.HorseService;
import com.StableManagement.stable_management_api.services.UserService;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NoteMapper {
    @Mapping(source = "creator.id", target = "creatorId")
    @Mapping(source = "horse.id", target = "horseId")
    NoteDto entityToDto(Note note);

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "creatorId", target = "creator", qualifiedByName = "creatorIdToCreator")
    @Mapping(source = "horseId", target = "horse", qualifiedByName = "horseIdToHorse")
    Note dtoToEntity(NoteDto noteDto, @Context UserService userService, @Context HorseService horseService);

    List<NoteDto> entitiesToDtos(List<Note> notes);
    List<Note> dtosToEntities(List<NoteDto> noteDtos, @Context UserService userService, @Context HorseService horseService);



    @Named("creatorIdToCreator")
    default User creatorIdToCreator(Long creatorId, @Context UserService userService){
        if(creatorId == null){
            return null;
        }

        return userService.getUserById(creatorId);
    }

    @Named("horseIdToHorse")
    default Horse horseIdToHorse(Long horseId, @Context HorseService horseService){
        if(horseId == null){
            return null;
        }

        return horseService.getFullHorse(horseId);
    }

    void patchEntityFromDto(NotePatchDto notePatchDto, @MappingTarget Note note);
}
