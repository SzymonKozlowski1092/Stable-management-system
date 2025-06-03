package com.StableManagement.stable_management_api.services;

import com.StableManagement.stable_management_api.dto.horse.HorsePatchDto;
import com.StableManagement.stable_management_api.dto.horse.HorseUpdateDto;
import com.StableManagement.stable_management_api.exceptions.NotFoundException;
import com.StableManagement.stable_management_api.models.Horse;
import com.StableManagement.stable_management_api.models.User;
import com.StableManagement.stable_management_api.repositories.HorseRepository;
import com.StableManagement.stable_management_api.repositories.UserRepository;

import java.util.List;

public class HorseService {
    private final HorseRepository horseRepository;
    private final UserRepository userRepository;

    public HorseService(HorseRepository horseRepository, UserRepository userRepository){
        this.horseRepository = horseRepository;
        this.userRepository = userRepository;
    }

    public Horse getHorse(Long id){
        return horseRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Nie znaleziono konia z id: " + id));
    }

    public List<Horse> getAllHorses(){
        return horseRepository.findAll();
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
                .orElseThrow(() -> new NotFoundException("Nie znaleziono nowego właściciela z id: " + id));

        horse.setAge(horseUpdateDto.getAge());
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
        if(horsePatchDto.getAge() != null) horse.setAge(horsePatchDto.getAge());
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