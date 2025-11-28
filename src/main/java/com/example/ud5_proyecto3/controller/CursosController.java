package com.example.ud5_proyecto3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

import com.example.ud5_proyecto3.model.Curso;
import com.example.ud5_proyecto3.model.Estudiante;
import com.example.ud5_proyecto3.service.CursoService;
import com.example.ud5_proyecto3.service.EstudianteService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequestMapping("/cursos") /* Captura la raiz de la carpeta cursos y todos los otros metodos parten de aqui */
public class CursosController {

    //Para sustituir la instanciacion *******************
    private CursoService cursoService;
    private EstudianteService estudianteService;

    public CursosController(CursoService cursoService, EstudianteService estudianteService){
        this.cursoService = cursoService;
        this.estudianteService = estudianteService;
    }
    //*********************************************************

    @GetMapping /*Al no tener ruta, responde a la raiz de cursoso que es recogido por el RequestMapping */
    public String lista(Model model){
        model.addAttribute("lista", cursoService.getCursos());
        //Coge de CursoService.getCursos() la lista de todos los cursos y la llama lista
        //Metiendola en el model
        return "cursos/cursos"; //Llama a la pantilla cursos que se encuetra en la carpeta cursos
    }

    @GetMapping("/{id}") //Viene de th:href que hay en los <a> de la pnatilla cursos
    public String curso_info(Model model, @PathVariable int id){ //Esta ruta tiene una variable por lo que se captura con PahtVariable
        Curso curso = cursoService.getCursoPorId(id); // En cursosServices hay un metodo que devuelve el curso con el id 
        model.addAttribute("curso", curso); // Metemos el curso en el model llamandolo curso
        return "cursos/curso-info"; //Llamamos a curso-info.html que esta en la carpeta cursos.
    }

    
    

}
