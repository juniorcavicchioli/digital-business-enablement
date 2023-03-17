package br.com.fiap.techbridge.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.techbridge.models.Conta;
import br.com.fiap.techbridge.utils.ControllerUtils;

@RestController
public class ContaController {

    // objeto que cria um log
    Logger log = LoggerFactory.getLogger(ContaController.class);
    // simulando um bd
    private List<Conta> contas = new ArrayList<>();

    // Sign up - CREATE
    @PostMapping("techbridge/api/conta")
    public ResponseEntity<Conta> signup(@RequestBody Conta conta){
        log.info("cadastrando conta: " + conta);
        if (conta.getSenha().isEmpty())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        
        var contaEncontrada = ControllerUtils.findContaByEmail(conta.getEmail(), contas);
        if (contaEncontrada.isPresent())
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        // gerando um id de maneira provisória
        conta.setId(contas.size() + 1l);
        contas.add(conta);
        return ResponseEntity.status(HttpStatus.CREATED).body(conta);
    }

    // LOG IN
    @PostMapping("techbridge/api/conta/login")
    public ResponseEntity<?> login(@RequestBody Conta conta){
        var contaEncontrada = ControllerUtils.findContaByEmail(conta.getEmail(), contas);
        if (!contaEncontrada.isPresent())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        if (!(conta.getSenha().equals(contaEncontrada.get().getSenha())))
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build() ;
        return ResponseEntity.status(HttpStatus.OK).build();
        
    }
    
    // DELETE
    @DeleteMapping("techbridge/api/conta/{id}")
    public ResponseEntity<Conta> delete(@PathVariable Long id){
        var contaEncontrada = ControllerUtils.findClassById(id, contas);
        if (!contaEncontrada.isPresent())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        
        contas.remove(contaEncontrada.get());
        return ResponseEntity.noContent().build();
    }

    // SHOW
    @GetMapping("techbridge/api/conta/{id}")
    public ResponseEntity<?> details(@PathVariable Long id){
        log.info("buscar conta " + id);
        var contaEncontrada = ControllerUtils.findClassById(id, contas);
        
        return ControllerUtils.idExiste(contaEncontrada);
    }
    
    // LISTAR
    @GetMapping("techbridge/api/conta")
    public List<Conta> index(){
        return contas;
    }

    // EDITAR
    @PutMapping("techbridge/api/conta/{id}")
    public ResponseEntity<Conta> update(@PathVariable Long id, @RequestBody Conta conta){
        var contaEncontrada = ControllerUtils.findClassById(id, contas);
        if (!contaEncontrada.isPresent())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        contas.remove(contaEncontrada.get());
        conta.setId(id);
        contas.add(conta);
        return ResponseEntity.ok(conta);
    }
}
