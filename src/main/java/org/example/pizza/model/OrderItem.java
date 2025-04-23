package org.example.pizza.model;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

public class OrderItem {
    private UUID orderId;
    private Integer pizzaId;
    private int quantity;
    private BigDecimal unitPrice;
    private Pizza pizza; // no persiste en BD

    public OrderItem() { }

    public OrderItem(UUID orderId, Integer pizzaId, int quantity, BigDecimal unitPrice) {
        this.orderId = orderId;
        this.pizzaId = pizzaId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public UUID getOrderId() { return orderId; }
    public void setOrderId(UUID orderId) { this.orderId = orderId; }

    public Integer getPizzaId() { return pizzaId; }
    public void setPizzaId(Integer pizzaId) { this.pizzaId = pizzaId; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public BigDecimal getUnitPrice() { return unitPrice; }
    public void setUnitPrice(BigDecimal unitPrice) { this.unitPrice = unitPrice; }

    public Pizza getPizza() { return pizza; }
    public void setPizza(Pizza pizza) { this.pizza = pizza; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderItem)) return false;
        OrderItem that = (OrderItem) o;
        return Objects.equals(orderId, that.orderId)
                && Objects.equals(pizzaId, that.pizzaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, pizzaId);
    }
}
