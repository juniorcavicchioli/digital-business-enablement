package br.com.fiap.techbridge.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.techbridge.models.Avaliacao;
import br.com.fiap.techbridge.utils.ControllerUtils;

@RestController
public class AvaliacaoController {
    
    private List<Avaliacao> avaliacoes = new ArrayList<>();

    // CRIAR
    @PostMapping("techbridge/api/avaliacao")
    public ResponseEntity<Avaliacao> create(@RequestBody Avaliacao avaliacao){
        var avaliacaoEncontrada = ControllerUtils.findClassById(avaliacao.getId(), avaliacoes);
        if (avaliacao.getEmpresaId() == null ||
            avaliacao.getContaId() == null ||
            avaliacao.getNota() == 0)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        if (avaliacaoEncontrada.isPresent())
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        avaliacao.setId(avaliacoes.size() + 1l);
        avaliacoes.add(avaliacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(avaliacao);
    }

    // DELETE
    @DeleteMapping("techbridge/api/avaliacao/{id}")
    public ResponseEntity<Avaliacao> delete(@PathVariable Long id){
        var avaliacaoEncontrada = ControllerUtils.findClassById(id, avaliacoes);
        if (!avaliacaoEncontrada.isPresent())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        
        avaliacoes.remove(avaliacaoEncontrada.get());
        return ResponseEntity.noContent().build();
    }

    // EDITAR
    @PutMapping("techbridge/api/avaliacao/{id}")
    public ResponseEntity<Avaliacao> update(@PathVariable Long id, @RequestBody Avaliacao avaliacao){
        var contaEncontrada = ControllerUtils.findClassById(id, avaliacoes);
        if (!contaEncontrada.isPresent())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        avaliacoes.remove(contaEncontrada.get());
        avaliacao.setId(id);
        avaliacoes.add(avaliacao);
        return ResponseEntity.ok(avaliacao);
    }

    // DETALHES
    @GetMapping("techbridge/api/avaliacao/{id}")
    public ResponseEntity<?> details(@PathVariable Long id){
        var empresaEncontrada = ControllerUtils.findClassById(id, avaliacoes);
        return ControllerUtils.idExiste(empresaEncontrada);
    }
    //JULGAR
    @PutMapping("techbridge/api/avaliacao/{id}/{contaId}")
    public String julgar(){
        return "ainda não implementado";
    }
}
