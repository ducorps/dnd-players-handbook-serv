package com.handbook.handbookapi.model;

import com.handbook.handbookapi.abstracts.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "price")
@SequenceGenerator(name = AbstractEntity.SEQUENCE_GENERATOR, sequenceName = "seq_price")
public class Price extends AbstractEntity {

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "currency", nullable = false)
    @Enumerated(EnumType.STRING)
    private Currency currency;

    public Price convertPrice(Price origin, Currency targetCurrency) {
        Integer newQuantity = origin.currency.convert(targetCurrency, origin.getQuantity());

        Price newPrice = new Price();

        newPrice.setCurrency(targetCurrency);
        newPrice.setQuantity(newQuantity);

        return newPrice;
    }
}


