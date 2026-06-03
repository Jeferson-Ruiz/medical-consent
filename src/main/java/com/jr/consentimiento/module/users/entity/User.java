package com.jr.consentimiento.module.users.entity;

import java.time.LocalDateTime;
import java.util.List;
import com.jr.consentimiento.module.users.enums.Role;
import com.jr.consentimiento.shared.enums.TypeIdentification;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "usuarios")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "use_id", unique = true)
    private Long id;

    @Column(name = "use_nombre", nullable = false)
    private String name;

    @Column(name = "use_apellido", nullable = false)
    private String lastName;

    @Column(name = "use_tipo_id", nullable = false)
    private TypeIdentification typeIdentification;

    @Column(name = "use_numero_id", nullable = false)
    private String identificationNumber;

    @Column(name = "use_email", nullable = false, unique = true)
    private String email;

    @Column(name = "use_role", nullable = false)
    private List<Role> roles;

    @Column(name = "use_contrasena",nullable = false)
    private String password;

    @Column(name = "use_active", nullable =  false)
    private boolean isActive; 

    @Column(name = "use_fecha_registro", nullable =  false)
    private LocalDateTime registrationDate;
}
