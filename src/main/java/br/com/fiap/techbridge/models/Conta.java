package br.com.fiap.techbridge.models;

public class Conta {
    private String email;
    private String senha;
    private String nome;
    
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

    @Override
    public String toString() {
        return "Conta [email=" + email + ", senha=" + senha + ", nome=" + nome + "]";
    }
    // gerar hash e equals
}
