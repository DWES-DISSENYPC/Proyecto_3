package com.example.ud5_proyecto3.model;

import java.util.ArrayList;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Estudiante {
    private int id;

    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;

    @NotBlank(message = "El Email no puede estar vacío")
    @Email(message = "El formato del email es incorrecto")
    private String email;
    private Curso curso;
    private static int cont = 0;

    public static ArrayList<Estudiante> estudiantes = new ArrayList<>();

    public Estudiante(String nombre, String email){
        this.nombre = nombre;
        this.email = email;
        this.id = cont;
        cont++;
    }

}
