package com.handbook.handbookapi.model;

public class Inventario {
    private Double pesoDisponivel;
    private List<Equipamento> equipamento;

    public Double getPesoDisponivel() { return pesoDisponivel; }

    public void setPesoDisponivel(Double pesoDisponivel) { this.pesoDisponivel = pesoDisponivel; }

    public List<Equipamento> getEquipamento() { return equipamento; }

    public void setEquipamento(List<Equipamento> equipamento) { this.equipamento = equipamento; }
}
