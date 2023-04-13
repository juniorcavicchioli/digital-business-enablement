package br.com.fiap.techbridge.config;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.techbridge.models.Avaliacao;
import br.com.fiap.techbridge.models.Empresa;
import br.com.fiap.techbridge.repository.AvaliacaoRepository;
import br.com.fiap.techbridge.repository.EmpresaRepository;
import br.com.fiap.techbridge.valueobjects.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.fiap.techbridge.models.Conta;
import br.com.fiap.techbridge.repository.ContaRepository;

@Configuration
public class DataBaseSeeder implements CommandLineRunner{

    @Autowired
    ContaRepository contaRepository;
    @Autowired
    EmpresaRepository empresaRepository;
    @Autowired
    AvaliacaoRepository avaliacaoRepository;

    private final List<Avaliacao> avaliacaoList = new ArrayList<>();

    Conta c1 = new Conta(1L, "example@example.com","12345678","Fulano", avaliacaoList);
    Conta c2 = new Conta(2L, "two@example.com","87654321","Deltrano", avaliacaoList);
    Conta c3 = new Conta(3L, "three@example.com","minhasenha","Beltrano", avaliacaoList);
    Conta c4 = new Conta(4L, "four@example.com","password","Robson", avaliacaoList);
    Conta c5 = new Conta(5L, "five@example.com","anotherpassword","Lucas", avaliacaoList);
    Conta c6 = new Conta(6L, "six@example.com","password","Adilson", avaliacaoList);
    Conta c7 = new Conta(7L, "seven@example.com","password","Carlos", avaliacaoList);
    Conta c8 = new Conta(8L, "eight@example.com","password","Jesus", avaliacaoList);
    Conta c9 = new Conta(9L, "nine@example.com","password","Maomé", avaliacaoList);
    Conta c10 = new Conta(10L, "ten@example.com","password","Maria", avaliacaoList);

    // new Endereco("Av. Lins de Vasconselos", "1222", null, "Cambuci", "São Paulo", "SP", "Brasil", "01538-001", null)
    Empresa e1 = new Empresa(1L, "FIAP - Aclimação", "VSTP Educacao S.A.", "Instituição acadêmica", "11.319.526/0007-40", null, avaliacaoList);
    Empresa e2 = new Empresa(2L, "Mercearia do Zé", null, "Varejo alimentício", null, null, avaliacaoList);
    Empresa e3 = new Empresa(3L, "Mercadinho do Manuel", null, "Varejo alimentício", null, null, avaliacaoList);
    Empresa e4 = new Empresa(4L, "Cabeleireiro", null, "Beleza", null, null, avaliacaoList);
    Empresa e5 = new Empresa(5L, "Salão de beleza", null, "Beleza", null, null, avaliacaoList);

    @Override
    public void run(String... args) throws Exception {

        contaRepository.saveAll(List.of(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10));
        empresaRepository.saveAll(List.of(e1,e2,e3,e4,e5));
        avaliacaoRepository.saveAll(List.of(
                new Avaliacao(1L, 1, "Lorem ipsum dolor sit amet", 0, 0, e1, c1),
                new Avaliacao(2L, 1, "Não gostei", 0, 0, e1, c2),
                new Avaliacao(3L, 2, "Desagradável", 0, 0, e1, c3),
                new Avaliacao(4L, 2, "Feio", 0, 0, e1, c4),
                new Avaliacao(5L, 5, "Muito bom", 0, 0, e1, c5),
                new Avaliacao(6L, 1, "O filme do Pelé é melhor", 0, 0, e2, c1),
                new Avaliacao(7L, 1, "Horrível", 0, 0, e2, c2),
                new Avaliacao(8L, 2, "De bom só os funcionários bonitos", 0, 0, e2, c3),
                new Avaliacao(9L, 2, "", 0, 0, e2, c4),
                new Avaliacao(10L, 5, "", 0, 0, e2, c5),
                new Avaliacao(11L, 3, "", 0, 0, e3, c1),
                new Avaliacao(12L, 3, "", 0, 0, e3, c2),
                new Avaliacao(13L, 4, "", 0, 0, e3, c3),
                new Avaliacao(14L, 4, "", 0, 0, e3, c4),
                new Avaliacao(15L, 5, "", 0, 0, e3, c5),
                new Avaliacao(16L, 3, "", 0, 0, e4, c1),
                new Avaliacao(17L, 3, "", 0, 0, e4, c2),
                new Avaliacao(18L, 4, "", 0, 0, e4, c3),
                new Avaliacao(19L, 4, "", 0, 0, e4, c4),
                new Avaliacao(20L, 5, "", 0, 0, e4, c5)
        ));
    }
    
}
