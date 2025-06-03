package com.StableManagement.stable_management_api.controllers;

import com.StableManagement.stable_management_api.enums.UserRole;
import com.StableManagement.stable_management_api.models.RegistrationCode;
import com.StableManagement.stable_management_api.services.RegistrationCodeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/registration-code")
public class RegistrationCodeController {
    private final RegistrationCodeService registrationCodeService;

    public RegistrationCodeController(RegistrationCodeService registrationCodeService){
        this.registrationCodeService = registrationCodeService;
    }

    @PostMapping("/generate")
    public ResponseEntity<RegistrationCode> generateCode(@RequestParam UserRole role){
        RegistrationCode code = registrationCodeService.generateCode(role);
        return ResponseEntity.ok(code);
    }
}
