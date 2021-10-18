package com.reactive.demo.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Entity()
@Table(name = "gio_categoria")
public class Category implements Serializable {
    @Id
    @NotNull(message = "El identificador de la categoría es obligatorio")
    @Column(name = "cat_id", nullable = false)
    private Integer idCategory;

    @NotEmpty(message = "La descripción de la categoría es obligatoria")
    @Column(name = "cat_desc", nullable = false, unique = true, length = 100)
    private String description;

    @NotNull(message = "La visibilidad de la categoría es obligatoria")
    @Column(name = "Visibilidad", nullable = false)
    private Integer visibility;
}
