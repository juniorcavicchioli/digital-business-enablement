package br.com.fiap.techbridge.utils;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.fiap.techbridge.interfaces.IModel;
import br.com.fiap.techbridge.models.Conta;
import br.com.fiap.techbridge.models.Empresa;

public class ControllerUtils {
    
    public static Optional<?> findClassById(Long id, List<? extends IModel> lista){
        return lista.stream()
        .filter(conta -> conta.getId().equals(id))
        .findFirst();
    }

    public static Optional<Conta> findContaByEmail(String email, List<Conta> contas){
        return contas.stream()
        .filter(conta -> conta.getEmail().equals(email))
        .findFirst();
    }

    public static Optional<Empresa> findEmpresaByRazao(String razaoSocial, List<Empresa> empresas){
        return empresas.stream()
        .filter(empresa -> empresa.getRazaoSocial().equals(razaoSocial))
        .findFirst();
    }

    public static ResponseEntity<?> idExiste(Optional<?> clazz){
        if (!clazz.isPresent())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok(clazz.get());
    }
}
