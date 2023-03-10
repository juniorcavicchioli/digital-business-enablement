package br.com.fiap.techbridge.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.techbridge.models.Conta;

@RestController
public class ContaController {
    
    @GetMapping("/api/conta")
    public Conta show(){
        return new Conta(
            "exemplo@exemplo.com",
            "123456789",
            "Fulano"
            );
    }
}
