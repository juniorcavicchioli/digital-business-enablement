package br.com.fiap.techbridge.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.techbridge.models.Empresa;
import br.com.fiap.techbridge.repository.EmpresaRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("techbridge/api/empresa")
public class EmpresaController {
    
    @Autowired
    EmpresaRepository repository;

    private Empresa getEmpresa(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Empresa não encontrada"));
    }
    @PostMapping()
    public ResponseEntity<Empresa> create(@RequestBody @Valid Empresa empresa, BindingResult result){
        repository.save(empresa);
        return ResponseEntity.status(HttpStatus.CREATED).body(empresa);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> show(@PathVariable Long id){
        var empresaEncontrada = getEmpresa(id);
        return ResponseEntity.ok(empresaEncontrada);
    }

    @GetMapping()
    public Page<Empresa> index(@RequestParam(required = false) String ramo,
                               @PageableDefault(size=5) Pageable pageable){
        if (ramo == null)
            return repository.findAll(pageable);
        return repository.findByRamo(ramo, pageable);
    }

    @PutMapping("{id}")
    public ResponseEntity<Empresa> update(@PathVariable Long id, @RequestBody @Valid Empresa empresa, BindingResult result){
        getEmpresa(id);
        empresa.setId(id);
        repository.save(empresa); // se aquela entidade já existe com aquele id, ele faz um update
        return ResponseEntity.ok(empresa);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Empresa> destroy(@PathVariable Long id){
        var empresaEncontrada = getEmpresa(id);
        repository.delete(empresaEncontrada);
        return ResponseEntity.noContent().build();
    }
}
