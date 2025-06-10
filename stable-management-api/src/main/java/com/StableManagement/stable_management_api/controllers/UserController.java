package com.StableManagement.stable_management_api.controllers;

import com.StableManagement.stable_management_api.dto.UserDto;
import com.StableManagement.stable_management_api.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long id){
        UserDto userDto = userService.getUserById(id);
        return ResponseEntity.ok().body(userDto);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UserDto> patchUser(@PathVariable Long id, @Valid @RequestBody UserDto userDto){
        UserDto patchedUser = userService.patchUser(id, userDto);
        return ResponseEntity.ok().body(patchedUser);
    }
}
