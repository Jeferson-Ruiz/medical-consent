package com.jr.consentimiento.module.users.dto;

import java.util.List;
import com.jr.consentimiento.module.users.entity.User;
import com.jr.consentimiento.module.users.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto{
    String email;
    List<Role> roles;
    
    public static UserResponseDto toDto(User user){
        UserResponseDto dto = new UserResponseDto();
        dto.setEmail(user.getEmail());
        dto.setRoles(user.getRoles());
        return dto;
    }
}