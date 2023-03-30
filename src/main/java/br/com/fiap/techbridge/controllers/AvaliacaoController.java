package br.com.fiap.techbridge.controllers;

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

import br.com.fiap.techbridge.models.Avaliacao;
import br.com.fiap.techbridge.repository.AvaliacaoRepository;
import br.com.fiap.techbridge.utils.ControllerUtils;

@RestController
@RequestMapping("techbridge/api/avaliacao")
public class AvaliacaoController {
    
    @Autowired
    AvaliacaoRepository repository;

    // CRIAR
    @PostMapping()
    public ResponseEntity<Avaliacao> create(@RequestBody Avaliacao avaliacao){
        /* preciso impedir alguem de criar duas avaliações da mesma empresa */
        if (avaliacao.getEmpresaId() == null ||
            avaliacao.getContaId() == null ||
            avaliacao.getNota() == 0)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        repository.save(avaliacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(avaliacao);
    }

    // DELETE
    @DeleteMapping("{id}")
    public ResponseEntity<Avaliacao> delete(@PathVariable Long id){
        var avaliacaoEncontrada = repository.findById(id);
        if (avaliacaoEncontrada == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // EDITAR
    @PutMapping("{id}")
    public ResponseEntity<Avaliacao> update(@PathVariable Long id, @RequestBody Avaliacao avaliacao){
        var contaEncontrada = repository.findById(id);
        if (contaEncontrada.isEmpty())
            return ResponseEntity.notFound().build();
        avaliacao.setJulgamento(contaEncontrada.get().getJulgamento());
        avaliacao.setContaId(contaEncontrada.get().getContaId());
        avaliacao.setId(id);
        repository.save(avaliacao);
        return ResponseEntity.ok(avaliacao);
    }

    // DETALHES
    @GetMapping("{id}")
    public ResponseEntity<?> details(@PathVariable Long id){
        var empresaEncontrada = repository.findById(id);
        return ControllerUtils.idExiste(empresaEncontrada);
    }
    
    //JULGAR
    @PutMapping("{id}/{contaId}")
    public String julgar(){
        return "ainda não implementado";
    }
}
