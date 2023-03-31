package br.com.fiap.techbridge.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Avaliacao{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "O id da conta que está avaliando é obrigatório")
    @Min(value=1, message = "A nota deve ter um valor entre 1 e 5")
    @Max(value=5, message = "A nota deve ter um valor entre 1 e 5")
    private int nota;
    private String comentario;
    private int julgamento = 0;
    
    @NotNull(message = "O id da empresa que está sendo avaliada é obrigatório")
    private Long empresaId;
    
    @ManyToOne
    @NotNull(message = "A nota deve ter um valor entre 1 e 5")
    private Conta conta;
}
