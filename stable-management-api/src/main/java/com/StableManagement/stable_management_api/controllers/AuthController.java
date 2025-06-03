package com.StableManagement.stable_management_api.controllers;

import com.StableManagement.stable_management_api.Utils.JwtUtil;
import com.StableManagement.stable_management_api.dto.AuthRequest;
import com.StableManagement.stable_management_api.dto.AuthResponse;
import com.StableManagement.stable_management_api.dto.RegisterRequest;
import com.StableManagement.stable_management_api.services.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<String> register(@RequestBody RegisterRequest request){
        authService.register(request);
        return ResponseEntity.status(HttpStatus.CREATED).body("Pomyślnie zarejestrowano użytkownika");
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request){
        String token = authService.login(request);
        return ResponseEntity.status(HttpStatus.OK).body(new AuthResponse(token));
    }
}
