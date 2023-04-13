package br.com.fiap.techbridge.controllers;

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

import br.com.fiap.techbridge.models.Avaliacao;
import br.com.fiap.techbridge.repository.AvaliacaoRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("techbridge/api/avaliacao")
public class AvaliacaoController {
    
    @Autowired
    AvaliacaoRepository repository;

    private Avaliacao getAvaliacao(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Avaliação não encontrada"));
    }
    @PostMapping()
    public ResponseEntity<Avaliacao> create(@RequestBody @Valid Avaliacao avaliacao, BindingResult result){
        /* preciso impedir alguem de criar duas avaliações da mesma empresa */
        repository.save(avaliacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(avaliacao);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> show(@PathVariable Long id){
        var avaliacaoEncontrada = getAvaliacao(id);
        return ResponseEntity.ok(avaliacaoEncontrada);
    }

    @PutMapping("{id}")
    public ResponseEntity<Avaliacao> update(@PathVariable Long id, @RequestBody @Valid Avaliacao avaliacao){
        var contaEncontrada = repository.findById(id);
        if (contaEncontrada.isEmpty())
            return ResponseEntity.notFound().build();
        avaliacao.setJulgamentoPositivo(contaEncontrada.get().getJulgamentoPositivo());
        avaliacao.setJulgamentoNegativo(contaEncontrada.get().getJulgamentoNegativo());
        avaliacao.setIdConta(contaEncontrada.get().getIdConta());
        avaliacao.setId(id);
        repository.save(avaliacao);
        return ResponseEntity.ok(avaliacao);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Avaliacao> delete(@PathVariable Long id){
        var avaliacaoEncontrada = getAvaliacao(id);
        repository.delete(avaliacaoEncontrada);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}/{contaId}")
    public String julgar(){
        return "ainda não implementado";
    }
}
