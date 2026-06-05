package com.jr.consentimiento.module.users.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jr.consentimiento.module.users.dto.RequestLogin;
import com.jr.consentimiento.module.users.dto.UserRequestDto;
import com.jr.consentimiento.module.users.dto.AuthResponseDto;
import com.jr.consentimiento.module.users.service.IAuthService;

@RestController
@RequestMapping("/auth")
public class UserController {

    private final IAuthService userService;

    public UserController(IAuthService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserRequestDto requestDto){
        AuthResponseDto user =  userService.register(requestDto);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody RequestLogin request){
        //temporal mientras implemento Jwt
        return null;
    }


}
