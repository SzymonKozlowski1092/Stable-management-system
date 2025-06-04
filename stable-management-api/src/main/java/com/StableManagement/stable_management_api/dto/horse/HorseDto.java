package com.StableManagement.stable_management_api.dto.horse;

import com.StableManagement.stable_management_api.enums.HorseGender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HorseDto {
    private Long id;
    private Long ownerId;
    private String name;
    private HorseGender gender;
    private LocalDate birthDate;
}
