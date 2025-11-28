package com.example.ud5_proyecto3.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ud5_proyecto3.model.Curso;
import com.example.ud5_proyecto3.model.Estudiante;

@Service
public class EstudianteService {
    private List<Estudiante> estudiantes = new ArrayList<>();

    private CursoService cursoService;

    public EstudianteService(CursoService cursoService){
        this.cursoService = cursoService;
    }

    public boolean registrarEstudiante(Estudiante e, int id_curso){
        Curso curso = cursoService.getCursoPorId(id_curso); // Obtenemos el curso referenciado por el id obtenido del formulario
        if(cursoService.setEstudiante(curso, e)){ // Se intenta añadir el estudiante a dicho curso (si hay plazas)
            estudiantes.add(e); // De haber plazas, se añade el estudiante al listado interno (simula INSERT en BBDD)
            e.setCurso(curso);  // También se añade el curso al estudiante (se inicializaba en null)
            return true; // Estudiante registrado
        }return false;   // Estudiante no registrado      
    }

    public List<Estudiante> getEstudiantesPorCurso(Curso c){
        return c.getEstudiantes();
    }

    public Estudiante getEstudiantePorId(int id){
        for(Estudiante e : estudiantes){
            if(e.getId() == id) return e;
        }
        return null;
    }
}
