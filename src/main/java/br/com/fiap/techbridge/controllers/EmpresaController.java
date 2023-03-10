package br.com.fiap.techbridge.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.fiap.techbridge.models.Empresa;

@RestController
public class EmpresaController {
    
    @GetMapping("/api/empresa")
    public Empresa show(){
        return new Empresa("The Code of Duty",
        "Consultoria de TI");
    }
}