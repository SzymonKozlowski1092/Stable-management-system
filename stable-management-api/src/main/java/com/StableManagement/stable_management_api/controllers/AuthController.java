package com.StableManagement.stable_management_api.controllers;

import com.StableManagement.stable_management_api.Utils.JwtUtil;
import com.StableManagement.stable_management_api.dto.AuthRequest;
import com.StableManagement.stable_management_api.dto.AuthResponse;
import com.StableManagement.stable_management_api.dto.RegisterRequest;
import com.StableManagement.stable_management_api.dto.UserDto;
import com.StableManagement.stable_management_api.services.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthenticationManager authManager,
                          JwtUtil jwtUtil,
                          AuthService authService){
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@Valid @RequestBody RegisterRequest request){
        UserDto newUserDto = authService.register(request);
        URI location = URI.create(String.format("/api/users/%d", newUserDto.getId()));
        return ResponseEntity.created(location).body(newUserDto);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login( @RequestBody AuthRequest request){
        String token = authService.login(request);
        return ResponseEntity.status(HttpStatus.OK).body(new AuthResponse(token));
    }
}
