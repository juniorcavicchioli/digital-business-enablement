package br.com.fiap.techbridge.models;

import br.com.fiap.techbridge.valueobjects.Endereco;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Empresa{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empresa", nullable = false)
    private Long id;
    @NotBlank(message = "A empresa tem que possuir um nome")
    @Column(name = "nome", nullable = false, length = 50)
    private String nome;
    @Column(name = "razao_social", length = 50)
    private String razaoSocial;
    @NotBlank(message = "A empresa tem que possuir um ramo de atuação")
    @Column(length = 50)
    private String ramo;
    @Column(name = "cnpj", length = 18)
    private String CNPJ;

    @Embedded
    private Endereco endereco;

    @OneToMany(mappedBy = "idEmpresa", cascade = CascadeType.ALL)
    private List<Avaliacao> avaliacoes = new ArrayList<>();
}
