package dto;

import java.time.LocalDate;

import enums2.HorseGender;

public class HorseDto {
    private Long id;
    private Long ownerId;
    private String name;
    private HorseGender gender;
    private LocalDate birthDate;

    public HorseDto() {}

    public HorseDto(Long id, Long ownerId, String name, HorseGender gender, LocalDate birthDate) {
        this.id = id;
        this.ownerId = ownerId;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HorseGender getGender() {
        return gender;
    }

    public void setGender(HorseGender gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
