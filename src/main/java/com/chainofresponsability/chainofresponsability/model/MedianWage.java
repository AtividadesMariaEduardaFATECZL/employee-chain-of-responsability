package com.chainofresponsability.chainofresponsability.model;

import com.chainofresponsability.chainofresponsability.ApplyINSSDiscount;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MedianWage implements ApplyINSSDiscount {
    private final BigDecimal MINIMUM_VALUE = new BigDecimal("1212.01");
    private final BigDecimal MAXIMUM_VALUE = new BigDecimal("2427.35");

    @Override
    public BigDecimal calculate(BigDecimal wage) {
        return (wage.multiply(new BigDecimal("0.9")).setScale(2, RoundingMode.HALF_UP));
    }

    @Override
    public boolean shouldApplyFor(BigDecimal wage) {
        return wage.compareTo(MINIMUM_VALUE) >= 0 && wage.compareTo(MAXIMUM_VALUE) <= -1;
    }
}
