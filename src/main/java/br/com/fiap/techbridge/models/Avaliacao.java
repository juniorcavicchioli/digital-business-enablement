package br.com.fiap.techbridge.models;

public class Avaliacao {
    private int contaId;
    private int nota;
    private String comentario;
    private int empresaId;
    private int julgamento;
    
    public Avaliacao(int contaId, int nota, int empresaId, int julgamento) {
        this.contaId = contaId;
        this.nota = nota;
        this.empresaId = empresaId;
        this.julgamento = julgamento;
    }

    public int getContaId() {
        return contaId;
    }

    public void setContaId(int contaId) {
        this.contaId = contaId;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(int empresaId) {
        this.empresaId = empresaId;
    }

    public int getJulgamento() {
        return julgamento;
    }

    public void setJulgamento(int julgamento) {
        this.julgamento = julgamento;
    }

    @Override
    public String toString() {
        return "Avaliacao [contaId=" + contaId + ", nota=" + nota + ", comentario=" + comentario + ", empresaId="
                + empresaId + ", julgamento=" + julgamento + "]";
    }

    
}
