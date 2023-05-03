package br.com.fiap.techbridge.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Avaliacao{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_avaliacao", nullable = false)
    private Long id;
    @NotNull(message = "O id da conta que está avaliando é obrigatório")
    @Min(value=1, message = "A nota deve ter um valor entre 1 e 5")
    @Max(value=5, message = "A nota deve ter um valor entre 1 e 5")
    @Column(length = 1)
    private int nota;
    @Column(length = 500)
    private String comentario;
    @Column(length = 6)
    private int julgamentoPositivo = 0;
    @Column(length = 6)
    private int julgamentoNegativo = 0;

    @ManyToOne
    @NotNull(message = "O id da empresa que está sendo avaliada é obrigatório")
    @JoinColumn(name = "id_empresa", nullable = false)
    private Empresa empresa;
    
    @ManyToOne
    @NotNull(message = "O id da conta que está avaliadando é obrigatório")
    @JoinColumn(name = "id_conta", nullable = false)
    private Conta conta;
}
