package org.example.pizza.web;

import java.math.BigDecimal;
import java.util.UUID;

public class OrderItemDto {
    private UUID pizzaId;
    private int quantity;
    private BigDecimal unitPrice;

    public UUID getPizzaId() {
        return pizzaId;
    }

    public void setPizzaId(UUID pizzaId) {
        this.pizzaId = pizzaId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }
}
