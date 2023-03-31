package br.com.fiap.techbridge.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String email;
    //@NotNull
    //@NotEmpty
    @NotBlank(message = "A senha tem que ter ao menos 8 caracteres")
    @Size(min = 8, message = "A senha tem que ter ao menos 8 caracteres")
    private String senha;
    @NotBlank(message = "O nome não foi preenchido.")
    private String nome;
    
}
