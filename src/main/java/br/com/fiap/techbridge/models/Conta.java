package br.com.fiap.techbridge.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_conta", nullable = false)
    private Long id;
    @NotBlank(message = "O e-mail deve ser preenchido")
    @Column(length = 50)
    private String email;
    @NotBlank(message = "A senha tem que ter ao menos 8 caracteres")
    @Size(min = 8, message = "A senha tem que ter ao menos 8 caracteres")
    //@JsonIgnore
    @Column(length = 50)
    private String senha;
    @NotBlank(message = "O nome deve ser preenchido")
    @Column(length = 50)
    private String nome;

    @OneToMany(mappedBy = "idConta", cascade = CascadeType.ALL)
    private List<Avaliacao> avaliacoes = new ArrayList<>();
}
