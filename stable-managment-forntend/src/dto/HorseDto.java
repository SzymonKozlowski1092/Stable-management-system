package dto;
import enums.HorseGender;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HorseDto {
    private Long id;
    private String name;
    private String ownerFullName;
    private String ownerPhone;
    private HorseGender gender;
    private List<NoteDto> notes = new ArrayList<>();

    public HorseDto() {}

    public HorseDto(Long id, String name, String ownerFullName, String ownerPhone, HorseGender gender, List<NoteDto> notes) {
        this.id = id;
        this.name = name;
        this.ownerFullName = ownerFullName;
        this.ownerPhone = ownerPhone;
        this.gender = gender;
        this.notes = notes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwnerFullName() {
        return ownerFullName;
    }

    public void setOwnerFullName(String ownerFullName) {
        this.ownerFullName = ownerFullName;
    }

    public String getOwnerPhone() {
        return ownerPhone;
    }

    public void setOwnerPhone(String ownerPhone) {
        this.ownerPhone = ownerPhone;
    }

    public HorseGender getGender() {
        return gender;
    }

    public void setGender(HorseGender gender) {
        this.gender = gender;
    }

    public List<NoteDto> getNotes() {
        return notes;
    }

    public void setNotes(List<NoteDto> notes) {
        this.notes = notes;
    }
}