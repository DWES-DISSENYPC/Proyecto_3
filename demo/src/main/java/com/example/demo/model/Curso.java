package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class Curso {

    private int id;
    private String nombre;
    private String descripcion;
    private int plazasDisponibles;
    private List<Estudiante> inscritos;

    public Curso() {
    }

    public Curso(int id, String nombre, String descripcion, int plazasDisponibles) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.plazasDisponibles = plazasDisponibles;
        this.inscritos = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPlazasDisponibles() {
        return plazasDisponibles;
    }

    public void setPlazasDisponibles(int plazasDisponibles) {
        this.plazasDisponibles = plazasDisponibles;
    }

    public List<Estudiante> getInscritos() {
        return inscritos;
    }

    public void setInscritos(Estudiante e) {

        this.inscritos.add(e);
    }

}
