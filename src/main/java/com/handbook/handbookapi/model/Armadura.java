package com.handbook.handbookapi.model;

public class Armadura extends Equipamento {
    private Integer forca;
    private Boolean furtividade;
    private Integer classeArmadura;

    public Integer getForca() {
        return forca;
    }

    public void setForca(Integer forca) {
        this.forca = forca;
    }

    public Boolean getFurtividade() {
        return furtividade;
    }

    public void setFurtividade(Boolean furtividade) {
        this.furtividade = furtividade;
    }

    public Integer getClasseArmadura() {
        return classeArmadura;
    }

    public void setClasseArmadura(Integer classeArmadura) {
        this.classeArmadura = classeArmadura;
    }
}
