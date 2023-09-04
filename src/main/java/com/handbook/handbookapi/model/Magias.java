package com.handbook.handbookapi.model;

public class Magias {
    private Integer tempoConjuracao;
    private String descricao;
    private Double alcance;
    private Integer duracao;
    private Componentes componentes;
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

    public Componentes getComponentes() {
        return componentes;
    }

    public void setComponentes(Componentes componentes) {
        this.componentes = componentes;
    }

    public String getObjetoNecessario() {
        return objetoNecessario;
    }

    public void setObjetoNecessario(String objetoNecessario) {
        this.objetoNecessario = objetoNecessario;
    }
}
