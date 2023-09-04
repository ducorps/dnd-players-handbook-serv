package com.handbook.handbookapi.model;

public class Magia {
    private Integer tempoConjuracao;
    private String descricao;
    private Double alcance;
    private Integer duracao;
    private Componente componente;
    private String objetoNecessario;

    public Integer getTempoConjuracao() { return tempoConjuracao; }

    public void setTempoConjuracao(Integer tempoConjuracao) { this.tempoConjuracao = tempoConjuracao; }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getAlcance() {
        return alcance;
    }

    public void setAlcance(Double alcance) {
        this.alcance = alcance;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }

    public Componente getComponente() {
        return componente;
    }

    public void setComponente(Componente componente) {
        this.componente = componente;
    }

    public String getObjetoNecessario() {
        return objetoNecessario;
    }

    public void setObjetoNecessario(String objetoNecessario) {
        this.objetoNecessario = objetoNecessario;
    }
}
