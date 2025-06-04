package com.StableManagement.stable_management_api.dto.horse;

import com.StableManagement.stable_management_api.enums.HorseGender;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.LocalDate;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class HorsePatchDto {
    private String name;
    private HorseGender gender;
    private LocalDate birthDate;
    private Long ownerId;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public HorseGender getGender() { return gender; }
    public void setGender(HorseGender gender) { this.gender = gender; }

    public LocalDate getBirthDate() { return birthDate; }
    public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; }

    public Long getOwnerId() { return ownerId; }
    public void setOwnerId(Long ownerId) { this.ownerId = ownerId; }
}
