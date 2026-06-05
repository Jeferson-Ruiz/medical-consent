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
public class AuthController {

    private final IAuthService authService;

    public AuthController(IAuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserRequestDto requestDto){
        AuthResponseDto user =  authService.register(requestDto);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody RequestLogin request){
        return ResponseEntity.ok(authService.login(request));
    }
}
