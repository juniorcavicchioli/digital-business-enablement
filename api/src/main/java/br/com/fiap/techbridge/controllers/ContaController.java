package br.com.fiap.techbridge.controllers;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.techbridge.models.Conta;
import br.com.fiap.techbridge.repository.ContaRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("techbridge/api/conta")
@Slf4j
public class ContaController {

    @Autowired
    ContaRepository repository;

    private Conta getConta(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Conta não encontrada"));
    }
    @PostMapping()
    public ResponseEntity<Conta> signup(@RequestBody @Valid Conta conta, BindingResult result){
        repository.save(conta);
        return ResponseEntity.status(HttpStatus.CREATED).body(conta);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> show(@PathVariable Long id){
        var contaEncontrada = getConta(id);
        return ResponseEntity.ok(contaEncontrada);
    }

    @GetMapping()
    public List<Conta> index(){ //@RequestParam String busca
        //log.info(busca);
        return repository.findAll();
    }

    @PutMapping("{id}")
    public ResponseEntity<Conta> update(@PathVariable Long id, @RequestBody @Valid Conta conta, BindingResult result){
        getConta(id);
        conta.setId(id);
        repository.save(conta);
        return ResponseEntity.ok(conta);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Conta> destroy(@PathVariable Long id){
        var contaEncontrada = getConta(id);
        repository.delete(contaEncontrada);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("login")
    public String login(){
        return "Ainda não implementado";
    }

}
