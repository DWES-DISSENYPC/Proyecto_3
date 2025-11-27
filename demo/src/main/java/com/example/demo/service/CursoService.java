package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Curso;
import com.example.demo.model.Estudiante;

@Service
public class CursoService {

    private List<Curso> cursos = new ArrayList<>();

    public List<Curso> CrearListaCursos () {

        this.cursos.add(new Curso(1, "DAW", "Diseño Aplicaciones Web", 40));
        this.cursos.add(new Curso(2, "Gestion", "aaaaaaaaaaaaaaaaaaaaa", 40));
        this.cursos.add(new Curso(3, "ASIR", "bbbbbbbbbbbbbbbbbbbbbb", 40));
        this.cursos.add(new Curso(4, "Ciencias Politicas", "Dbbbbbbbbbbbbbbbbbb", 40));
        this.cursos.add(new Curso(5, "Diseño", "Dddddddddddddddddd Web", 40));
        this.cursos.add(new Curso(6, "Mecanica", "Dffffffffffffffffffffffffb", 40));
        this.cursos.add(new Curso(7, "TKE", "DggggggggggggggggggggggggWeb", 40));
        this.cursos.add(new Curso(8, "Ciencias Ouras", "Dhhhhhhhhhhhhhhhhhhhhhhhhhhhh Web", 40));

        return cursos;
    }

    public List<Curso> getCursos() {


        return cursos;
    }

    public Curso getCursoPorId(int id) {

        for(Curso c: cursos) {

            if (c.getId() == id)  return c; 

        }

        return null;
    }

    public List<Curso> getCursosDisponibles() {
        List<Curso> c = new ArrayList<>();

        for (Curso curso : cursos) {

            if (curso.getPlazasDisponibles() > 0) c.add(curso);
        }

        return c;
    }


    public List<Curso> registrarCurso(Curso c) {

        cursos.add(c);

        return cursos;
    }
    
    public Boolean setEstudiante(int id_curso, Estudiante e) {

        for (Curso elemento : cursos) {

            if (elemento.getId() == id_curso && elemento.getPlazasDisponibles() > 0) {

                elemento.setPlazasDisponibles(elemento.getPlazasDisponibles()-1);
                elemento.setInscritos(e);
                return true;
            }

        }

        return false;
    }
}


