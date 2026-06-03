package com.jr.consentimiento.module.users.service;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.jr.consentimiento.module.users.dto.RequestLogin;
import com.jr.consentimiento.module.users.dto.UserRequestDto;
import com.jr.consentimiento.module.users.dto.UserResponseDto;
import com.jr.consentimiento.module.users.entity.User;
import com.jr.consentimiento.module.users.enums.Role;
import com.jr.consentimiento.module.users.repository.UserReposotory;
import jakarta.persistence.EntityNotFoundException;

@Service
public class UserServiceImpl implements IUserService {

    private final UserReposotory userReposotory;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserReposotory userReposotory, PasswordEncoder passwordEncoder) {
        this.userReposotory = userReposotory;
        this.passwordEncoder = passwordEncoder;
    }

    public UserResponseDto createUser(UserRequestDto userDto){
        isDuplicateEmail(userDto.getEmail());
        User user = userDto.toEntity();
        user.setRoles(List.of(Role.USER));
        user.setRegistrationDate(LocalDateTime.now());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setActive(true);
        userReposotory.save(user);
        return UserResponseDto.toDto(user);
    }

    public void login(RequestLogin requestLogin){
        User user = userReposotory.findByEmail(requestLogin.email())
            .orElseThrow(() -> new EntityNotFoundException("usuario no encontrado"));
        if (user.isActive() && 
            user.getEmail().equals(requestLogin.email()) &&
            user.getPassword().matches(requestLogin.password())) {
        }
    }

    //hepers
    private void isDuplicateEmail(String email){
        if (userReposotory.existsByEmail(email)) {
            throw new IllegalArgumentException("Email ya registrado en el sistema");
        }
    }
  
}