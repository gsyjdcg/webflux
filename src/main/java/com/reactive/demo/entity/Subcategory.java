package com.reactive.demo.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Entity()
@Table(name = "gio_subcategoria")
public class Subcategory implements Serializable {
    @Id
    @NotNull(message = "El identificador de la subcategoría es obligatorio")
    @Column(name = "cat_id", nullable = false)
    private Integer idSubcategory;

    @NotEmpty(message = "La descripción de la subcategoría es obligatoria")
    @Column(name = "cat_desc", nullable = false, unique = true, length = 100)
    private String description;

    @NotNull(message = "La visiblidad de la subcategoría es obligatoria")
    @Column(name = "Visibilidad", nullable = false)
    private Integer visibility;
}
