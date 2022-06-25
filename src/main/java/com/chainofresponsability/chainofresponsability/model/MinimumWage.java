package com.chainofresponsability.chainofresponsability.model;

import com.chainofresponsability.chainofresponsability.ApplyINSSDiscount;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static java.math.BigDecimal.ZERO;

public class MinimumWage implements ApplyINSSDiscount {

    private final BigDecimal MAXIMUM_VALUE = new BigDecimal("1212.00");

    @Override
    public BigDecimal calculate(BigDecimal wage) {
        return (wage.multiply(new BigDecimal("0.075")).setScale(2, RoundingMode.HALF_UP));
    }

    @Override
    public boolean shouldApplyFor(BigDecimal wage) {
        return wage.compareTo(MAXIMUM_VALUE) <= 0;
    }
}
