package com.handbook.handbookapi.model;

public class Arma  extends Equipamento{
    private Double dano;
    private String propriedades;

    public Double getDano() {
        return dano;
    }

    public void setDano(Double dano) {
        this.dano = dano;
    }

    public String getPropriedades() {
        return propriedades;
    }

    public void setPropriedades(String propriedades) {
        this.propriedades = propriedades;
    }
}
