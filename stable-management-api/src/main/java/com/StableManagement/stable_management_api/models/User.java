package com.StableManagement.stable_management_api.models;

import com.StableManagement.stable_management_api.enums.UserRole;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Pattern(regexp = "^[\\p{L}]+$", message = "Imię może zawierać tylko litery")
    @NotBlank(message = "Imie nie może być puste")
    private String firstName;

    @Pattern(regexp = "^[\\p{L}]+$", message = "Nazwisko może zawierać tylko litery")
    @NotBlank(message = "Nazwisko nie moze być puste")
    private String lastName;

    @NotBlank(message = "Nazwa użytkownika nie może być pusta")
    @Column(unique = true, nullable = false)
    private String username;

    @Pattern(regexp = "\\+?[0-9]{9,15}", message = "Zły format numeru telefonu")
    @NotBlank(message = "Numer telefonu nie może być pusty")
    @Column(unique = true)
    private String phoneNumber;

    @NotNull(message = "Rola użytkownika musi być wybrana")
    @Enumerated(EnumType.STRING)
    private UserRole role;

    @NotNull
    private Boolean isDeleted;

    @OneToMany(mappedBy = "owner")
    private List<Horse> horses = new ArrayList<>();

    @JsonIgnore
    private String password;

    public User() {}

    public Long getId(){ return id; }

    public void setFirstName(String firstName){ this.firstName = firstName; }
    public String getFirstName() { return this.firstName; }

    public void setLastName(String lastName){ this.lastName = lastName; }
    public String getLastName() { return this.lastName; }

    public String getUsername(){ return username; }
    public void setUsername(String username){ this.username = username; }

    public String getPhoneNumber(){ return phoneNumber; }
    public void setPhoneNumber(String phoneNumber){ this.phoneNumber = phoneNumber; }

    public UserRole getRole() { return  role; }
    public void setRole(UserRole role) { this.role = role; }

    public List<Horse> getHorses() { return horses; }
    public void setHorses(List<Horse> horses) { this.horses = horses; }

    public Boolean getDeleted() { return isDeleted; }
    public void setDeleted(Boolean deleted) { isDeleted = deleted; }

    public void setPassword(String password){ this.password = password; }
    public String getPassword(){ return password; }
}