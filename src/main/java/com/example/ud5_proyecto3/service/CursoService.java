package com.example.ud5_proyecto3.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ud5_proyecto3.model.Curso;
import com.example.ud5_proyecto3.model.Estudiante;

@Service
public class CursoService {

    // instanciamos y rellenamos la lista de cursos
    private static List<Curso> cursos = new ArrayList<>(List.of
    (
        new Curso("Iniciación al Senderismo", "Curso básico para aprender a realizar rutas cortas con seguridad."),
        new Curso("Orientación con Brújula", "Aprende a interpretar mapas y utilizar la brújula en entornos naturales."),
        new Curso("Seguridad en Montaña", "Normas fundamentales para prevenir riesgos durante las excursiones."),
        new Curso("Fotografía de Naturaleza", "Técnicas esenciales para capturar paisajes y fauna salvaje."),
        new Curso("Técnicas de Supervivencia", "Recursos prácticos para desenvolverse en situaciones adversas."),
        new Curso("Primeros Auxilios en Ruta", "Cómo actuar frente a lesiones comunes durante una ruta."),
        new Curso("Planificación de Rutas Largas", "Diseño de itinerarios de media y larga distancia."),
        new Curso("Interpretación del Entorno Natural", "Identificación de flora, fauna y señales del terreno.")
    ));

    // Metodo para devolver la lista de cursos solicitada desde CursosControler
    public List<Curso> getCursos(){
        return cursos;
    }

    public List<Curso> getCursosDisponibles(){
        List<Curso> cursos_disponibles = new ArrayList<>();
        for(Curso c : cursos){
            if(c.getPlazas_disponibles() > 0) cursos_disponibles.add(c);
        }
        return cursos_disponibles;
    }

    public Curso getCursoPorId(int id){
        for(Curso c : cursos){
            if(c.getId() == id) return c;
        }
        return null;
    }

    public void registrarCurso(Curso c){
        cursos.add(c);
    }

    public boolean setEstudiante(Curso c, Estudiante e){
        int n_plazas = c.getPlazas_disponibles();
        if(n_plazas > 0){
            c.getEstudiantes().add(e);
            c.setPlazas_disponibles(n_plazas-1);
            return true;
        }
        return false;
    }
}
