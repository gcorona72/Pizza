package org.example.pizza.web;

import java.math.BigDecimal;
import java.util.UUID;

public class ProcessPaymentRequest {
    private UUID orderId;
    private BigDecimal amount;
    private String method;

    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
