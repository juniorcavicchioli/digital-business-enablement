package br.com.fiap.techbridge.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.techbridge.models.Avaliacao;
import br.com.fiap.techbridge.repository.AvaliacaoRepository;
import jakarta.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("techbridge/api/avaliacao")
@Slf4j
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

    @GetMapping()
    public Page<Avaliacao> index(@RequestParam(required = false) String empresa,
                                 @RequestParam(required = false) String conta,
                                 @PageableDefault(size=5) Pageable pageable){
        log.info(empresa, conta);
        if (empresa == null) {
            if (conta == null)
                return repository.findAll(pageable);
            return repository.findByContaId(conta, pageable);
        }
        return repository.findByEmpresaId(empresa, pageable);
        // outra lógica para o mesmo problema
//        if (conta == null && empresa == null)
//            return repository.findAll(pageable);
//        if (conta == null)
//            return repository.findByEmpresaId(empresa, pageable);
//        return repository.findByContaId(conta, pageable);
    }

    @PutMapping("{id}")
    public ResponseEntity<Avaliacao> update(@PathVariable Long id, @RequestBody @Valid Avaliacao avaliacao){
        var contaEncontrada = repository.findById(id);
        if (contaEncontrada.isEmpty())
            return ResponseEntity.notFound().build();
        avaliacao.setJulgamentoPositivo(contaEncontrada.get().getJulgamentoPositivo());
        avaliacao.setJulgamentoNegativo(contaEncontrada.get().getJulgamentoNegativo());
        avaliacao.setConta(contaEncontrada.get().getConta());
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
