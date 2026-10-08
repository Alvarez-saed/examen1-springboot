package com.examen.examen1.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CursoDTO {

    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "La descripción es obligatoria")
    private String descripcion;

    @NotNull(message = "La duración en horas es obligatoria")
    private Integer duracionHoras;

    @NotBlank(message = "El nivel es obligatorio")
    private String nivel;
}