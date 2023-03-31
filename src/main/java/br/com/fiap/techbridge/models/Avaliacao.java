package br.com.fiap.techbridge.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
public class Avaliacao{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "O id da conta que está avaliando é obrigatório")
    private Long contaId;
    @NotNull(message = "A nota deve ter um valor entre 1 e 5")
    @Min(value=1, message = "A nota deve ter um valor entre 1 e 5")
    @Max(value=5, message = "A nota deve ter um valor entre 1 e 5")
    private int nota;
    private String comentario;
    @NotNull(message = "O id da empresa que está sendo avaliada é obrigatório")
    private Long empresaId;
    private int julgamento = 0;
    
    public Avaliacao(){}

    public Avaliacao(Long contaId, int nota, Long empresaId) {
        this.contaId = contaId;
        this.nota = nota;
        this.empresaId = empresaId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getContaId() {
        return contaId;
    }

    public void setContaId(Long contaId) {
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

    public Long getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(Long empresaId) {
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
        return "Avaliacao [id=" + id + ", contaId=" + contaId + ", nota=" + nota + ", comentario=" + comentario + ", empresaId="
                + empresaId + ", julgamento=" + julgamento + "]";
    }

    
}
