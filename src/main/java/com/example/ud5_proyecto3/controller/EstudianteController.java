package com.example.ud5_proyecto3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ud5_proyecto3.model.Estudiante;
import com.example.ud5_proyecto3.service.CursoService;
import com.example.ud5_proyecto3.service.EstudianteService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/estudiantes") //Captura todas las url que empiecen por /estudiantes
public class EstudianteController {

    // Para sustituir instanciar las dos clases de servicios que se van a usar
    private EstudianteService estudianteService;
    private CursoService cursoService;

    public EstudianteController(EstudianteService estudianteService, CursoService cursoService){
        this.estudianteService = estudianteService;
        this.cursoService = cursoService;
    }

    //captura la ruta /registrar

    @GetMapping("/registrar") // Llamado desde welcome
    public String registrarEstudiante(Model model){ // instanciamos el Model para poder ponerle datos
        model.addAttribute("estudiante", new Estudiante(null, null));
        // Ponemos en el model un estudiante vacio para ser usado por el formulario
        model.addAttribute("lista_cursos", cursoService.getCursos());
        // Ponemos en el model la lista de cursos que nos devuelve getCursos()
        return "estudiantes/registrar-estudiante";
        // Llamamos a la plantilla registrar-estudiante que se encuentra en la carpeta estudiantes
    }

   /* @PostMapping("/registrar")
    public String registrarEstudiante(
        // Model model,
        @ModelAttribute Estudiante e,
        @RequestParam int id_curso
    ){
        System.out.println(e);
        if(estudianteService.registrarEstudiante(e, id_curso)){
            return "estudiantes/registro-ok";
        }
        return "redirect:/estudiantes/registrar-estudiante";
    }*/

    @PostMapping("/registrar")
    public String procesarFormulario(@Valid @ModelAttribute ("estudiante") Estudiante estudiante, BindingResult resultado,  @RequestParam("id_curso") int idCurso, Model model) {
    //ModelAttribute para coger el objeto que viene del formulario, @RequestParam para recoger los parametros sueltos

        if(resultado.hasErrors()) { // comprueba todas las validaciones del formulario

            model.addAttribute("lista_cursos", cursoService.getCursos()); //Vuelve a poner en el model la lista
            // El objeto Estudiante no hace falta volver a ponerlo, ya está en el BindingResult
            return "estudiantes/registrar-estudiante"; // regresa al html del formulario al detectar cualquier error, enviando los mensajes de error detectados

        }

        if(estudianteService.registrarEstudiante(estudiante, idCurso)){ // Lla al metodo registrar estudiante del servicio estudiantes 
            // si devuelve true carga el html de confirmacion
            return "estudiantes/registro-ok";
        }

        // si no devuelve true, carga en el model la lista y el error personalizado.cursosController
        // El objeto Estudiante no es preciso volver a ponerlo en el model.
        model.addAttribute("lista_cursos", cursoService.getCursos());
        // Ponemos en el model la lista de cursos que nos devuelve getCursos()
        model.addAttribute("error", "El curso no tiene plazas disponibles");
        return "estudiantes/registrar-estudiante";
        // Llamamos a la plantilla registrar-estudiante que se encuentra en la carpeta estudiantes
    }
}
