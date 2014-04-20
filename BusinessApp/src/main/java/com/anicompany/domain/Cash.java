package com.anicompany.domain;

import java.math.BigDecimal;
import java.util.Currency;

/**
 * Created by Anirban on 4/19/2014.
 */
public class Cash {
    BigDecimal value;
    Currency currency;

    @Override
    public String toString() {
        return "Cash{" +
                "value=" + value +
                ", currency=" + currency +
                '}';
    }
}
