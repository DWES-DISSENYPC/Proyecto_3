package com.example.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Estudiante {

    private int id;
    private String nombre;
    private String email;
    private int idCurso;


    public Estudiante(int id, String nombre, String email, int idCurso) {
        this.nombre = nombre;
        this.email = email;
        this.idCurso= idCurso;
    }

}
