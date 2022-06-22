package com.chainofresponsability.chainofresponsability;

import java.math.BigDecimal;

import static java.math.BigDecimal.ZERO;

public class MinimumWage implements ApplyINSSDiscount{

    private final BigDecimal MAXIMUM_VALUE = new BigDecimal("1212.00");

    @Override
    public BigDecimal calculate(BigDecimal wage) {
        if(!shouldApplyFor(wage)) throw new RuntimeException("Salario não se aplica para essa regra");
        return ZERO;
    }

    @Override
    public boolean shouldApplyFor(BigDecimal wage) {
        return wage.compareTo(MAXIMUM_VALUE) <= 0;
    }
}
