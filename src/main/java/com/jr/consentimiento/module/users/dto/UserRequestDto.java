package com.jr.consentimiento.module.users.dto;

import java.util.List;
import com.jr.consentimiento.module.users.entity.User;
import com.jr.consentimiento.module.users.enums.Role;
import com.jr.consentimiento.shared.enums.TypeIdentification;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDto {
    private String name;
    private String lastName;
    private TypeIdentification typeIdentification;
    private String identificationNumber;
    private String email;
    private List<Role> roles;
    private String password;

    public User toEntity(){
        User user = new User();
        user.setName(this.name);
        user.setLastName(this.lastName);
        user.setTypeIdentification(this.typeIdentification);
        user.setIdentificationNumber(this.identificationNumber);
        user.setEmail(this.email);
        user.setRoles(this.roles);
        user.setPassword(this.password);
        return user;
    }
}