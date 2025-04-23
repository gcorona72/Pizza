package org.example.pizza.web;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class OrderDto {
    private UUID id;
    private UUID userId;
    private BigDecimal totalPrice;
    private String status;
    private List<OrderItemDto> items;

    // Getters y Setters
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public UUID getUserId() { return userId; }
    public void setUserId(UUID userId) { this.userId = userId; }

    public BigDecimal getTotalPrice() { return totalPrice; }
    public void setTotalPrice(BigDecimal totalPrice) { this.totalPrice = totalPrice; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public List<OrderItemDto> getItems() { return items; }
    public void setItems(List<OrderItemDto> items) { this.items = items; }
}
