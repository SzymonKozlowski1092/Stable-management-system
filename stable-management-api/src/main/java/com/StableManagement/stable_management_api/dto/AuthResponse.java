package com.StableManagement.stable_management_api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AuthResponse {
    private String token;

    public AuthResponse(String token){
        this.token = token;
    }
}
