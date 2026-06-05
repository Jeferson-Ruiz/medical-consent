package com.jr.consentimiento.module.users.service;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.jr.consentimiento.module.users.dto.RequestLogin;
import com.jr.consentimiento.module.users.dto.UserRequestDto;
import com.jr.consentimiento.module.users.dto.AuthResponseDto;
import com.jr.consentimiento.module.users.entity.User;
import com.jr.consentimiento.module.users.enums.Role;
import com.jr.consentimiento.module.users.repository.UserReposotory;
import com.jr.consentimiento.module.users.security.IJwtService;
import jakarta.persistence.EntityNotFoundException;

@Service
public class AuthService implements IAuthService {

    private final UserReposotory userReposotory;
    private final PasswordEncoder passwordEncoder;
    private final IJwtService jwtService;

    public AuthService(UserReposotory userReposotory, PasswordEncoder passwordEncoder, IJwtService jwtService) {
        this.userReposotory = userReposotory;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public AuthResponseDto register(UserRequestDto userDto){
        isDuplicateEmail(userDto.getEmail());
        User user = userDto.toEntity();
        user.setRoles(List.of(Role.USER));
        user.setRegistrationDate(LocalDateTime.now());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setActive(true);
        userReposotory.save(user);
        return new AuthResponseDto(jwtService.generateToken(user));
    }

    public AuthResponseDto login(RequestLogin requestLogin){
        User user = getUserByEmail(requestLogin.email());
        validatePassword(requestLogin.password(), user.getPassword());

        return new AuthResponseDto(jwtService.generateToken(user));
    }

    //hepers
    private void isDuplicateEmail(String email){
        if (userReposotory.existsByEmail(email)) {
            throw new IllegalArgumentException("Email ya registrado en el sistema");
        }
    }

    private User getUserByEmail(String email){
        User user = userReposotory.findByEmail(email)
            .orElseThrow(() -> new EntityNotFoundException("usuario no encontrado"));
        return user;
    }

    private void validatePassword(String password, String encodedPassword){
        if (!passwordEncoder.matches(password, encodedPassword)) {
            throw new BadCredentialsException("Contraseña incorrecta");
        }
    }
  
}