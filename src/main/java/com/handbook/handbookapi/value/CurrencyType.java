package com.handbook.handbookapi.value;

public enum CurrencyType {

    COPPER(1, "cp"),
    SILVER(10, "sp"),
    ELECTRUM(50, "ep"),
    GOLD(100, "gp"),
    PLATINUM(1000, "pp");

    private Integer copperValue;
    private String abbreviation;

    CurrencyType(Integer copperValue, String abbreviation) {
        this.copperValue = copperValue;
        this.abbreviation = abbreviation;
    }

    public Integer convert(CurrencyType target, Integer amount) {
        return (this.copperValue * amount) / target.copperValue;
    }

    public static CurrencyType fromAbbreviation(String abbreviation) {
        for (CurrencyType currencyType : CurrencyType.values()) {
            if (currencyType.abbreviation.equals(abbreviation)) {
                return currencyType;
            }
        }
        return null;
    }
}
