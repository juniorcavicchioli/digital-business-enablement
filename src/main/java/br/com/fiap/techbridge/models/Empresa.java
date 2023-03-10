package br.com.fiap.techbridge.models;

public class Empresa {
    private String razaoSocial;
    private String nome;
    private String ramo;
    private String CNPJ;
    private String endereco;

    public Empresa(String razaoSocial, String ramo) {
        this.razaoSocial = razaoSocial;
        this.ramo = ramo;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRamo() {
        return ramo;
    }

    public void setRamo(String ramo) {
        this.ramo = ramo;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String cNPJ) {
        CNPJ = cNPJ;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Empresa [razaoSocial=" + razaoSocial + ", nome=" + nome + ", ramo=" + ramo + ", CNPJ=" + CNPJ
                + ", endereco=" + endereco + "]";
    }
}
