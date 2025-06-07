package dto;

import java.util.ArrayList;
import java.util.List;

public class UserDto {
    private Long id;
    private String fullName;
    private String phone;
    private List<HorseDto> horses = new ArrayList<>();

    public UserDto() {}

    public UserDto(Long id, String fullName, String phone, List<HorseDto> horses) {
        this.id = id;
        this.fullName = fullName;
        this.phone = phone;
        this.horses = horses;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<HorseDto> getHorses() {
        return horses;
    }

    public void setHorses(List<HorseDto> horses) {
        this.horses = horses;
    }
}
