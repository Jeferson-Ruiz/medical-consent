package com.jr.consentimiento.module.users.service;

import com.jr.consentimiento.module.users.dto.RequestLogin;
import com.jr.consentimiento.module.users.dto.UserRequestDto;
import com.jr.consentimiento.module.users.dto.AuthResponseDto;

public interface IAuthService {

 AuthResponseDto register(UserRequestDto userDto);
 
 void login(RequestLogin requestLogin);
}
