package com.jr.consentimiento.module.patient.entity;

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
@Table(name = "pacientes")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pac_id", unique = true)
    private Long id;

    @Column(name = "pac_nombre", nullable = false)
    private String name;

    @Column(name = "pac_apellido", nullable = false)
    private String lastName;

    @Column(name = "pac_tipo_id", nullable = false)
    private TypeIdentification typeIdentification;

    @Column(name = "pac_numero_id", nullable = false, unique = true)
    private String numberIdentification;

    @Column(name = "pac_telefono", nullable = false)
    private String phone;

    @Column(name = "pac_email", nullable = false)
    private String email;

    @Column(name = "pac_eps", nullable = false)
    private String eps;

    // mirar la manera de conectar con los Pdf
}
