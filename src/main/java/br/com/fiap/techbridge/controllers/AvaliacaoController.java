package br.com.fiap.techbridge.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.fiap.techbridge.models.Avaliacao;

@RestController
public class AvaliacaoController {
    
    @GetMapping("/api/avaliacao")
    public Avaliacao show(){
        return new Avaliacao(
            1, 
            4, 
            1, 
            0
            );
    }
}
