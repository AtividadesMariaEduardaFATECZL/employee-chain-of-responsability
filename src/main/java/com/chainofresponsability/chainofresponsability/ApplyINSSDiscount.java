package com.chainofresponsability.chainofresponsability;

import java.math.BigDecimal;

public interface ApplyINSSDiscount {
    BigDecimal calculate(BigDecimal wage);
    boolean shouldApplyFor(BigDecimal wage);
}
