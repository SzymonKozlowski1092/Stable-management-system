package com.StableManagement.stable_management_api.dto;

import com.StableManagement.stable_management_api.enums.UserRole;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Pattern;

public class UserDto {
    private Long id;

    @Pattern(regexp = "^[\\p{L}]+$", message = "Imię może zawierać tylko litery")
    private String firstName;

    @Pattern(regexp = "^[\\p{L}]+$", message = "Nazwisko może zawierać tylko litery")
    private String lastName;

    private String username;

    @Pattern(regexp = "\\+?[0-9]{9,15}", message = "Zły format numeru telefonu")
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
