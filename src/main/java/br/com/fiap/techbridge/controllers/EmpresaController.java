package br.com.fiap.techbridge.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.techbridge.models.Empresa;
import br.com.fiap.techbridge.repository.EmpresaRepository;
import br.com.fiap.techbridge.utils.ControllerUtils;

@RestController
@RequestMapping("techbridge/api/empresa")
public class EmpresaController {
    
    @Autowired
    EmpresaRepository repository;
    
    // CADASTRAR
    @PostMapping()
    public ResponseEntity<?> create(@RequestBody Empresa empresa){
        var empresaEncontrada = repository.findFirstByRazaoSocial(empresa.getRazaoSocial());
        if (empresaEncontrada != null)
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        repository.save(empresa);
        return ResponseEntity.status(HttpStatus.CREATED).body(empresa);
    }

    // SHOW
    @GetMapping("{id}")
    public ResponseEntity<?> details(@PathVariable Long id){
        var empresaEncontrada = repository.findById(id);
        return ControllerUtils.idExiste(empresaEncontrada);
    }
    
    // LISTAR
    @GetMapping()
    public List<Empresa> index(){
        return repository.findAll();
    }

    // Editar
    @PutMapping("{id}")
    public ResponseEntity<Empresa> update(@PathVariable Long id, @RequestBody Empresa empresa){
        var empresaEncontrada = repository.findById(id);
        if (empresaEncontrada.isEmpty())
            return ResponseEntity.notFound().build();
        empresa.setId(id);
        repository.save(empresa); // se aquela entidade já existe com aquele id, ele faz um update
        return ResponseEntity.ok(empresa);
    }
}
