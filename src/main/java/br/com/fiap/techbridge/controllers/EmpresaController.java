package br.com.fiap.techbridge.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.techbridge.models.Empresa;
import br.com.fiap.techbridge.repository.EmpresaRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("techbridge/api/empresa")
public class EmpresaController {
    
    @Autowired
    EmpresaRepository repository;
    
    // CADASTRAR
    @PostMapping()
    public ResponseEntity<?> create(@RequestBody @Valid Empresa empresa, BindingResult result){
        
        repository.save(empresa);
        return ResponseEntity.status(HttpStatus.CREATED).body(empresa);
    }

    // SHOW
    @GetMapping("{id}")
    public ResponseEntity<?> details(@PathVariable Long id){
        var empresaEncontrada = repository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
            "empresa não encontrada"));
        return ResponseEntity.ok(empresaEncontrada);
    }
    
    // LISTAR
    @GetMapping()
    public List<Empresa> index(){
        return repository.findAll();
    }

    // Editar
    @PutMapping("{id}")
    public ResponseEntity<Empresa> update(@PathVariable Long id, @RequestBody @Valid Empresa empresa, BindingResult result){
        repository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "empresa não encontrada"));
        empresa.setId(id);
        repository.save(empresa); // se aquela entidade já existe com aquele id, ele faz um update
        return ResponseEntity.ok(empresa);
    }

    // DELETE
    @DeleteMapping("{id}")
    public ResponseEntity<Empresa> delete(@PathVariable Long id){
        var empresaEncontrada = repository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
            "Erro ao apagar. Empresa não encontrada"));
        repository.delete(empresaEncontrada);
        return ResponseEntity.noContent().build();
    }
}
