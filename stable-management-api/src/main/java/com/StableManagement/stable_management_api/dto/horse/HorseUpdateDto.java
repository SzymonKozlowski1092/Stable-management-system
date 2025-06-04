package com.StableManagement.stable_management_api.dto.horse;

import com.StableManagement.stable_management_api.enums.HorseGender;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class HorseUpdateDto {

    @NotBlank(message = "Imię konia jest wymagane")
    private String name;

    @NotNull(message = "Płeć konia jest wymagana")
    @Enumerated(EnumType.STRING)
    private HorseGender gender;

    @NotNull(message = "Data urodzenia jest wymagana")
    private LocalDate birthDate;

    @NotNull(message = "ID właściciela jest wymagane")
    private Long ownerId;

    // Gettery i settery
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public HorseGender getGender() { return gender; }
    public void setGender(HorseGender gender) { this.gender = gender; }

    public LocalDate getBirthDate() { return birthDate; }
    public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; }

    public Long getOwnerId() { return ownerId; }
    public void setOwnerId(Long ownerId) { this.ownerId = ownerId; }
}
