package br.com.fiap.techbridge.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.techbridge.models.Empresa;
import br.com.fiap.techbridge.utils.ControllerUtils;

@RestController
public class EmpresaController {
    
    private List<Empresa> empresas = new ArrayList<>();
    
    // CADASTRAR
    @PostMapping("techbridge/api/empresa")
    public ResponseEntity<?> create(@RequestBody Empresa empresa){
        var empresaEncontrada = ControllerUtils.findEmpresaByRazao(empresa.getRazaoSocial(), empresas);
        if (empresaEncontrada.isPresent())
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        empresa.setId(empresas.size() + 1l);
        empresas.add(empresa);
        return ResponseEntity.status(HttpStatus.CREATED).body(empresa);
    }

    // SHOW
    @GetMapping("techbridge/api/empresa/{id}")
    public ResponseEntity<?> details(@PathVariable Long id){
        var empresaEncontrada = ControllerUtils.findClassById(id, empresas);
        return ControllerUtils.idExiste(empresaEncontrada);
    }
    
    // LISTAR
    @GetMapping("techbridge/api/empresa")
    public List<Empresa> index(){
        return empresas;
    }
}
