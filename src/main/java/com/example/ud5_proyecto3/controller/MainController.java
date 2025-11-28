package com.example.ud5_proyecto3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    /*Lo unico que hace es escuchar la raiz del proyecto y enviar a welcome */

    @GetMapping("/")
    public String welcome(){
        return "welcome";
    }
}
