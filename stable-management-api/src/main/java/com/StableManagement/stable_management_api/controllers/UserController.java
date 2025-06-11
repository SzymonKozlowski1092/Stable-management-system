package com.StableManagement.stable_management_api.controllers;

import com.StableManagement.stable_management_api.dto.UserDto;
import com.StableManagement.stable_management_api.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    @PreAuthorize("hasRole('MANAGER')")
    public ResponseEntity<List<UserDto>> getUsers(){
        List<UserDto> userDtos = userService.getUsers();
        return ResponseEntity.ok().body(userDtos);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('MANAGER','EMPLOYEE') or " +
            "@userSecurity.isSelf(#id, authentication)")
    public ResponseEntity<UserDto> getUser(@PathVariable Long id){
        UserDto userDto = userService.getUserDtoById(id);
        return ResponseEntity.ok().body(userDto);
    }

    @PatchMapping("/{id}")
    @PreAuthorize("hasRole('MANAGER')")
    public ResponseEntity<UserDto> patchUser(@PathVariable Long id, @Valid @RequestBody UserDto userDto){
        UserDto patchedUser = userService.patchUser(id, userDto);
        return ResponseEntity.ok().body(patchedUser);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('MANAGER')")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
