package com.StableManagement.stable_management_api.services;

import com.StableManagement.stable_management_api.Utils.JwtUtil;
import com.StableManagement.stable_management_api.dto.AuthRequest;
import com.StableManagement.stable_management_api.dto.RegisterRequest;
import com.StableManagement.stable_management_api.dto.UserDto;
import com.StableManagement.stable_management_api.exceptions.RegistrationException;
import com.StableManagement.stable_management_api.mappers.UserMapper;
import com.StableManagement.stable_management_api.models.RegistrationCode;
import com.StableManagement.stable_management_api.models.User;
import com.StableManagement.stable_management_api.repositories.RegistrationCodeRepository;
import com.StableManagement.stable_management_api.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class AuthService {
    private final AuthenticationManager authManager;
    private final UserRepository userRepository;
    private final RegistrationCodeRepository registrationCodeRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final UserMapper userMapper;

    public AuthService(UserRepository userRepository,
                       RegistrationCodeRepository registrationCodeRepository,
                       PasswordEncoder passwordEncoder,
                       JwtUtil jwtUtil,
                       AuthenticationManager authManager,
                       UserMapper userMapper){
        this.userRepository = userRepository;
        this.registrationCodeRepository = registrationCodeRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
        this.authManager = authManager;
        this.userMapper = userMapper;
    }

    @Transactional
    public UserDto register(RegisterRequest request){
        RegistrationCode code = registrationCodeRepository.findByCode(request.getCode())
                .orElseThrow(() -> new RegistrationException("Nieprawidłowy kod rejestracyjny"));

        if (code.isUsed()) {
            throw new RegistrationException("Kod rejestracyjny został już użyty");
        }
        if (code.getExpirationDate().isBefore(LocalDateTime.now())) {
            throw new RegistrationException("Kod rejestracyjny wygasł");
        }

        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setUsername(request.getUsername());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(code.getRole());

        userRepository.save(user);

        code.setUsed(true);
        registrationCodeRepository.save(code);

        return userMapper.entityToDto(user);
    }

    public String login(AuthRequest request){
        Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getUsername(),
                request.getPassword()
        ));

        UserDetails user = (UserDetails) authentication.getPrincipal();
        return jwtUtil.generateToken(user);
    }
}
