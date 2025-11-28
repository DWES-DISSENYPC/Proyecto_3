package com.example.ud5_proyecto3.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Curso {

    private static final int MAX_PLAZAS = 10;
    private int id;
    private String nombre;
    private String descripcion;
    private int plazas_disponibles;
    private List<Estudiante> estudiantes;
    private static int cont = 0;

    public Curso(String nombre, String descripcion){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.plazas_disponibles = MAX_PLAZAS;
        estudiantes = new ArrayList<>();
        this.id = cont;
        cont++;
    }
}
