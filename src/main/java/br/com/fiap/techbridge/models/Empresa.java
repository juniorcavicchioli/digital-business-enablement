package br.com.fiap.techbridge.models;

import br.com.fiap.techbridge.interfaces.IModel;

public class Empresa implements IModel{
    private Long id;
    private String razaoSocial;
    private String nome;
    private String ramo;
    private String CNPJ;
    private String endereco;

    public Empresa(String razaoSocial, String ramo) {
        this.razaoSocial = razaoSocial;
        this.ramo = ramo;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        return "Empresa [id=" + id + ", razaoSocial=" + razaoSocial + ", nome=" + nome + ", ramo=" + ramo + ", CNPJ=" + CNPJ
                + ", endereco=" + endereco + "]";
    }
}
