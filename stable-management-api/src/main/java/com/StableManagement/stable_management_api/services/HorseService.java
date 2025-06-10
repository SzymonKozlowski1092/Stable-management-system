package com.StableManagement.stable_management_api.services;

import com.StableManagement.stable_management_api.dto.horse.HorseDto;
import com.StableManagement.stable_management_api.exceptions.NotFoundException;
import com.StableManagement.stable_management_api.mappers.HorseMapper;
import com.StableManagement.stable_management_api.models.Horse;
import com.StableManagement.stable_management_api.repositories.HorseRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HorseService {
    private final HorseRepository horseRepository;
    private final UserService userService;
    private final HorseMapper horseMapper;

    public HorseService(HorseRepository horseRepository, UserService userService, HorseMapper horseMapper){
        this.horseRepository = horseRepository;
        this.userService = userService;
        this.horseMapper = horseMapper;
    }

    public Horse getFullHorse(Long id){
        return horseRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Nie znaleziono konia z id: " + id));
    }

    public HorseDto getHorseDto(Long id){
        Horse horse =  horseRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Nie znaleziono konia z id: " + id));

        return horseMapper.entityToDto(horse);
    }

    public List<HorseDto> getAllHorses(){
        List<Horse> horses = horseRepository.findAll();
        return horseMapper.entitiesToDtos(horses);
    }

    public HorseDto createHorse(HorseDto horseDto) {
        Horse horse = horseMapper.dtoToEntity(horseDto, userService);
        Horse saved = horseRepository.save(horse);

        return horseMapper.entityToDto(saved);
    }

    public void deleteHorse(Long id){
        if(!horseRepository.existsById(id)){
            throw new NotFoundException("Nie znaleziono konia z id: " + id);
        }

        horseRepository.deleteById(id);
    }

    public HorseDto updateHorse(Long id, HorseDto horseDto){
        Horse horse = horseRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Nie znaleziono konia z id: " + id));

        horseMapper.updateEntityFromDto(horseDto, horse, userService);
        Horse updatedHorse = horseRepository.save(horse);

        return horseMapper.entityToDto(updatedHorse);
    }
}