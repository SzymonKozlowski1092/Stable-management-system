package com.StableManagement.stable_management_api.services;

import com.StableManagement.stable_management_api.enums.UserRole;
import com.StableManagement.stable_management_api.models.RegistrationCode;
import com.StableManagement.stable_management_api.repositories.RegistrationCodeRepository;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RegistrationCodeService {

    private final RegistrationCodeRepository registrationCodeRepository;
    private final Random random = new Random();

    public RegistrationCodeService(RegistrationCodeRepository registrationCodeRepository){
        this.registrationCodeRepository = registrationCodeRepository;
    }

    public RegistrationCode generateCode(UserRole role){
        int code;
        do{
            code = 100000 + random.nextInt(900000);
        }while(registrationCodeRepository.existsByCode(code));

        RegistrationCode registrationCode = new RegistrationCode(code, role);

        return registrationCodeRepository.save(registrationCode);
    }

}
