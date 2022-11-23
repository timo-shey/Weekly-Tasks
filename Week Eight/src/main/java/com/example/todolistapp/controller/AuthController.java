package com.example.todolistapp.controller;

import com.example.todolistapp.pojo.ApiResponse;
import com.example.todolistapp.pojo.UserDto;
import com.example.todolistapp.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/auth")
@AllArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@Valid @RequestBody UserDto userDto){
        UserDto user = userService.getUser(userDto);
        return new ResponseEntity<>(""+ user.getUsername() + " signed in successfully.", HttpStatus.CREATED);
    }
}
