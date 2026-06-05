package com.jr.consentimiento.module.users.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jr.consentimiento.module.users.dto.RequestLogin;
import com.jr.consentimiento.module.users.dto.UserRequestDto;
import com.jr.consentimiento.module.users.dto.UserResponseDto;
import com.jr.consentimiento.module.users.service.IUserService;

@RestController
@RequestMapping("/auth")
public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> createUser(@RequestBody UserRequestDto requestDto){
        UserResponseDto user =  userService.createUser(requestDto);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody RequestLogin request){
        //temporal mientras implemento Jwt
        return null;
    }


}
