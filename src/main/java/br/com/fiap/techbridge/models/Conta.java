package br.com.fiap.techbridge.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

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
    
    protected Conta(){}
    
    public Conta(String email, String senha, String nome) {
        this.email = email;
        this.senha = senha;
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    @Override
    public String toString() {
        return "Conta [email=" + email + ", senha=" + senha + ", nome=" + nome + "]";
    }
    // gerar hash e equals
}
