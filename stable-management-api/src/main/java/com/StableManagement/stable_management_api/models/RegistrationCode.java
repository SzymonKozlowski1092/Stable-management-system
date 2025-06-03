package com.StableManagement.stable_management_api.models;

import com.StableManagement.stable_management_api.enums.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;


@Entity
@Table(name = "RegistrationCode")
public class RegistrationCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Kod jest wymagany")
    @Min(value = 100000)
    @Max(value = 999999)
    @Column(unique = true)
    private int code;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Rola do rejestracji jest wymagana")
    private UserRole role;

    private LocalDateTime expirationDate;

    private boolean isUsed;

    public RegistrationCode() {}

    public RegistrationCode(int code, UserRole role){
        this.code = code;
        this.role = role;
        this.expirationDate = LocalDateTime.now().plusMinutes(5);
        this.isUsed = false;
    }

    public Long getId() { return id; }

    public int getCode() { return code; }
    public void setCode(int code) { this.code = code; }

    public UserRole getRole() { return role; }
    public void setRole(UserRole role) { this.role = role; }

    public LocalDateTime getExpirationDate() { return expirationDate; }
    public void setExpirationDate(LocalDateTime expirationDate) { this.expirationDate = expirationDate; }

    public boolean isUsed() { return isUsed; }
    public void setUsed(boolean used) { isUsed = used; }
}
