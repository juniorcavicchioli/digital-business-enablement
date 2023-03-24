package br.com.fiap.techbridge.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.techbridge.models.Conta;
import br.com.fiap.techbridge.repository.ContaRepository;
import br.com.fiap.techbridge.utils.ControllerUtils;

@RestController
@RequestMapping("techbridge/api/conta")
public class ContaController {

    // objeto que cria um log
    Logger log = LoggerFactory.getLogger(ContaController.class);

    @Autowired
    ContaRepository repository;
    
    // Sign up - CREATE
    @PostMapping()
    public ResponseEntity<Conta> signup(@RequestBody Conta conta){
        log.info("cadastrando conta: " + conta);
        if (conta.getSenha().isEmpty())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        
        repository.save(conta);
        return ResponseEntity.status(HttpStatus.CREATED).body(conta);
    }

    // LOG IN
    /*
    @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody Conta conta){
        var contaEncontrada = repository.findByEmail(conta.getEmail());
        if (!contaEncontrada.isPresent())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        if (!(conta.getSenha().equals(contaEncontrada.get().getSenha())))
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build() ;
        return ResponseEntity.status(HttpStatus.OK).build();   
    } */
    
    // DELETE
    @DeleteMapping("{id}")
    public ResponseEntity<Conta> delete(@PathVariable Long id){
        var contaEncontrada = repository.findById(id);

        if (!contaEncontrada.isPresent())
            return ResponseEntity.notFound().build();
        
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // SHOW
    @GetMapping("{id}")
    public ResponseEntity<?> details(@PathVariable Long id){
        log.info("buscar conta " + id);
        var contaEncontrada = repository.findById(id);
        
        return ControllerUtils.idExiste(contaEncontrada);
    }
    
    // LISTAR
    @GetMapping()
    public List<Conta> index(){
        return repository.findAll();
    }

    // EDITAR
    @PutMapping("{id}")
    public ResponseEntity<Conta> update(@PathVariable Long id, @RequestBody Conta conta){
        var contaEncontrada = repository.findById(id);
        if (contaEncontrada.isEmpty())
            return ResponseEntity.notFound().build();

        conta.setId(id);
        repository.save(conta); // se aquela entidade já existe com aquele id, ele faz um update
        return ResponseEntity.ok(conta);
    }
}
