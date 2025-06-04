package com.StableManagement.stable_management_api.controllers;

import com.StableManagement.stable_management_api.dto.horse.HorseDto;
import com.StableManagement.stable_management_api.models.Horse;
import com.StableManagement.stable_management_api.services.HorseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/horses")
public class HorseController {
    private final HorseService horseService;

    public HorseController(HorseService horseService){
        this.horseService = horseService;
    }

    @GetMapping
    public ResponseEntity<List<HorseDto>> getAllHorses(){
        List<HorseDto> horses = horseService.getAllHorses();
        return ResponseEntity.status(HttpStatus.OK).body(horses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HorseDto> getHorse(@PathVariable Long id){
        HorseDto horseDto = horseService.getHorse(id);
        return ResponseEntity.status(HttpStatus.OK).body(horseDto);
    }
}