package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Curso;
import com.example.demo.model.Estudiante;

@Service
public class EstudianteService {

    private List<Estudiante> estudiantes = new ArrayList<>();


//********************para falsa instancia */
    private CursoService cursoService;

    public EstudianteService(CursoService cursoService){
        this.cursoService = cursoService;
    }
//****************************************************** */

    public List<Estudiante> CrearListaEstudiantes () {

        estudiantes.add(new Estudiante (1, "Juan", "uan.asdñfh@ña.com", 1));
        estudiantes.add(new Estudiante (2, "Pedro", "uan.asdñfh@ña.com", 1));

        return estudiantes;
    }

    public boolean registrarEstudiante(Estudiante e, int id_curso) {

        boolean ok = cursoService.setEstudiante(id_curso, e);
        if (ok) estudiantes.add(e);

        return ok;
    }

    public List<Estudiante> getEstudiantePorCurso (Curso c) {

        for (Curso curso: cursoService.getCursos()) {

            if (curso.getId() == c.getId()) {

                return curso.getInscritos();
            }

        }

        return null;


    }

    public Estudiante getEstudiantePorId(int id) {

        for (Estudiante estudiante : estudiantes) {

            if (estudiante.getId() == id )  return estudiante;

        }

        return null;

    }
}
