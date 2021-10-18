package com.reactive.demo.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
@Entity(name = "usuario")
@Table(name = "usuario")
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;

    @NotEmpty(message = "El NIF es obligatorio")
    @Column(nullable = false, unique = true)
    private String nif;

    @NotEmpty(message = "El nombre es obligatorio")
    @Column(nullable = false)
    private String name;

    @NotEmpty(message = "El apellido es obligatorio")
    @Column(nullable = false)
    private String surname;

    private Integer age;
}
