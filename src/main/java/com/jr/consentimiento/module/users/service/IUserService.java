package com.jr.consentimiento.module.users.service;

import com.jr.consentimiento.module.users.dto.RequestLogin;
import com.jr.consentimiento.module.users.dto.UserRequestDto;
import com.jr.consentimiento.module.users.dto.UserResponseDto;

public interface IUserService {

 UserResponseDto createUser(UserRequestDto userDto);
 
 void login(RequestLogin requestLogin);
}
