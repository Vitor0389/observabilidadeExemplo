package com.example.appB.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppBController {
    @GetMapping("/mundo")
    public String mundo() throws InterruptedException{

        // Simula um trabalho mais pesado (ex: consulta em banco)

        Thread.sleep(300);

        return "Mundo!";

    }
}
