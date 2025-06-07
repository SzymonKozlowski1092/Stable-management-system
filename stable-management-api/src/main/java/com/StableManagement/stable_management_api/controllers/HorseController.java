package com.StableManagement.stable_management_api.controllers;

import com.StableManagement.stable_management_api.dto.horse.HorseDto;
import com.StableManagement.stable_management_api.models.Horse;
import com.StableManagement.stable_management_api.services.HorseService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
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

    @PostMapping()
    public ResponseEntity<HorseDto> createHorse(@Valid @RequestBody HorseDto horseDto){
        HorseDto createdHorse = horseService.createHorse(horseDto);
        URI location = URI.create(String.format("/api/horses/%d", createdHorse.getId()));
        return ResponseEntity.created(location).body(createdHorse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHorse(@PathVariable Long id){
        horseService.deleteHorse(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<HorseDto> updateHorse(@PathVariable Long id, @Valid @RequestBody HorseDto horseDto){
        HorseDto updatedHorse = horseService.updateHorse(id, horseDto);
        return ResponseEntity.ok().body(updatedHorse);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<HorseDto> patchHorse(@PathVariable Long id, @RequestBody HorseDto horseDto){
        HorseDto updatedHorse = horseService.updateHorse(id, horseDto);
        return ResponseEntity.ok().body(updatedHorse);
    }
}