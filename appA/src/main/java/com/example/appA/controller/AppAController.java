package com.example.appA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class AppAController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/ola")
    public String ola() throws InterruptedException {

        //Simula algum trabalho
        Thread.sleep(100);

        //Chama o App-B
        String respostaDoB = restTemplate.getForObject("http://appb:8080/mundo", String.class);

        return "Olá" + respostaDoB;
    }
}
