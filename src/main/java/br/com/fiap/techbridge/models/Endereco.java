package br.com.fiap.techbridge.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_endereco", nullable = false)
    private Long id;

    @Column(length = 100)
    private String rua;
    @Column(length = 10)
    private String numero;
    @Column(length = 50)
    private String complemento;
    @Column(length = 50)
    private String bairro;
    @Column(length = 50)
    private String cidade;
    @Column(length = 2)
    private String estado;
    @Column(length = 50)
    private String pais;
    @Column(length = 8)
    private String cep;

    @OneToOne(mappedBy = "idEndereco")
    private Empresa empresa;
}
