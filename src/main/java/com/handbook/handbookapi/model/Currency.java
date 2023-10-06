package com.handbook.handbookapi.model;

import java.util.List;

public enum Currency {
    COPPER(1),
    SILVER(10),
    ELECTRUM(50),
    GOLD(100),
    PLATINUM(1000);

    private Integer copperValue;

    Currency(Integer copperValue) {
        this.copperValue = copperValue;
    }

    public Integer convert(Currency target, Integer quantity) {
        return (this.copperValue * quantity) / target.copperValue;
    }
}
