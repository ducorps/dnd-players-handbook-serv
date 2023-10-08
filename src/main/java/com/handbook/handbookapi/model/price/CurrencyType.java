package com.handbook.handbookapi.model.price;

public enum CurrencyType {
    COPPER(1),
    SILVER(10),
    ELECTRUM(50),
    GOLD(100),
    PLATINUM(1000);

    private Integer copperValue;

    CurrencyType(Integer copperValue) {
        this.copperValue = copperValue;
    }

    public Integer convert(CurrencyType target, Integer quantity) {
        return (this.copperValue * quantity) / target.copperValue;
    }
}
