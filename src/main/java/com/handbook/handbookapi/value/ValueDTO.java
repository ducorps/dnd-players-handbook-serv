package com.handbook.handbookapi.value;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class ValueDTO {
    private Integer amount;
    private String currencyType;

    public Value toEntity() {
        Value value = new Value();
        value.setAmount(this.amount);
        value.setCurrencyType(CurrencyType.valueOf(this.currencyType));
        return value;
    }

    public static ValueDTO fromEntity(Value value) {
        if (Objects.isNull(value)) {
            return null;
        };

        ValueDTO valueDTO = new ValueDTO();
        valueDTO.setAmount(value.getAmount());
        valueDTO.setCurrencyType(value.getCurrencyType().toString());
        return valueDTO;
    }
}
