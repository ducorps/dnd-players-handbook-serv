package com.handbook.handbookapi.model;

public class Price {
    private Integer quantity;
    private Currency currency;

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Price convertPrice(Price origin, Currency targetCurrency) {
        Integer newQuantity = origin.currency.convert(targetCurrency, origin.getQuantity());

        Price newPrice = new Price();

        newPrice.setCurrency(targetCurrency);
        newPrice.setQuantity(newQuantity);

        return newPrice;
    }
}
