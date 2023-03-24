package br.com.fiap.techbridge.utils;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import br.com.fiap.techbridge.interfaces.IModel;

public class ControllerUtils {
    
    @Deprecated
    public static Optional<?> findClassById(Long id, List<? extends IModel> lista){
        return lista.stream()
        .filter(conta -> conta.getId().equals(id))
        .findFirst();
    }

    public static ResponseEntity<?> idExiste(Optional<?> clazz){
        if (!clazz.isPresent())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(clazz.get());
    }
}
