package com.StableManagement.stable_management_api.services;

import com.StableManagement.stable_management_api.dto.horse.HorseDto;
import com.StableManagement.stable_management_api.dto.horse.HorsePatchDto;
import com.StableManagement.stable_management_api.dto.horse.HorseUpdateDto;
import com.StableManagement.stable_management_api.exceptions.NotFoundException;
import com.StableManagement.stable_management_api.mappers.HorseMapper;
import com.StableManagement.stable_management_api.models.Horse;
import com.StableManagement.stable_management_api.models.User;
import com.StableManagement.stable_management_api.repositories.HorseRepository;
import com.StableManagement.stable_management_api.repositories.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HorseService {
    private final HorseRepository horseRepository;
    private final UserRepository userRepository;
    private final HorseMapper horseMapper;

    public HorseService(HorseRepository horseRepository, UserRepository userRepository, HorseMapper horseMapper){
        this.horseRepository = horseRepository;
        this.userRepository = userRepository;
        this.horseMapper = horseMapper;
    }

    public HorseDto getHorse(Long id){
        Horse horse =  horseRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Nie znaleziono konia z id: " + id));

        return horseMapper.entityToDto(horse);
    }

    public List<HorseDto> getAllHorses(){
        List<Horse> horses = horseRepository.findAll();
        return horseMapper.entitiesToDtos(horses);
    }

    public void deleteHorse(Long id){
        if(!horseRepository.existsById(id)){
            throw new NotFoundException("Nie znaleziono konia z id: " + id);
        }

        horseRepository.deleteById(id);
    }

    public void updateHorse(Long id, HorseUpdateDto horseUpdateDto){
        Horse horse = horseRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Nie znaleziono konia z id: " + id));


        User newOwner = userRepository
                .findById(horseUpdateDto.getOwnerId())
                .orElseThrow(() -> new NotFoundException("Nie znaleziono nowego właściciela z id: " + horseUpdateDto.getOwnerId()));

        horse.setGender(horseUpdateDto.getGender());
        horse.setOwner(newOwner);
        horse.setName(horseUpdateDto.getName());
        horse.setBirthDate(horseUpdateDto.getBirthDate());

        horseRepository.save(horse);
    }

    public void patchHorse(Long id, HorsePatchDto horsePatchDto){
        Horse horse = horseRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Nie znaleziono konia z id: " + id));

        if(horsePatchDto.getName() != null) horse.setName(horsePatchDto.getName());
        if(horsePatchDto.getGender() != null) horse.setGender(horsePatchDto.getGender());
        if(horsePatchDto.getBirthDate() != null) horse.setBirthDate(horsePatchDto.getBirthDate());

        if(horsePatchDto.getOwnerId() != null){
            User newOwner = userRepository
                    .findById(horsePatchDto.getOwnerId())
                    .orElseThrow(() -> new NotFoundException("Nie znaleziono użytkownika z id: " + horsePatchDto.getOwnerId()));

            horse.setOwner(newOwner);
        }

        horseRepository.save(horse);
    }
}