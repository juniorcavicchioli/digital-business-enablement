package br.com.fiap.techbridge.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.fiap.techbridge.models.Conta;
import br.com.fiap.techbridge.repository.ContaRepository;

@Configuration
public class DataBaseSeeder implements CommandLineRunner{

    @Autowired
    ContaRepository contaRepository;

    @Override
    public void run(String... args) throws Exception {
        contaRepository.saveAll(List.of(
            new Conta(1L, "example@example.com","12345678","Fulano"),
            new Conta(2L, "two@example.com","87654321","Deltrano"),
            new Conta(3L, "three@example.com","minhasenha","Beltrano"),
            new Conta(4L, "four@example.com","password","Robson")
        ));
    }
    
}
