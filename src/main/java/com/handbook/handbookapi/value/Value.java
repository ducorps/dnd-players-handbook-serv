package com.handbook.handbookapi.value;

import com.handbook.handbookapi.common.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "value")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = AbstractEntity.SEQUENCE_GENERATOR, sequenceName = "seq_price")
public class Value extends AbstractEntity {

    @Column(name = "amount", nullable = false)
    private Integer amount;

    @Column(name = "currency_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private CurrencyType currencyType;

    public Value convertValue(Value origin, CurrencyType targetCurrencyType) {
        Integer newAmount = origin.currencyType.convert(targetCurrencyType, origin.getAmount());

        Value newValue = new Value();

        newValue.setCurrencyType(targetCurrencyType);
        newValue.setAmount(newAmount);

        return newValue;
    }
}
