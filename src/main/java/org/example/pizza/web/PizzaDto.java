package org.example.pizza.web;

import java.math.BigDecimal;
import java.util.UUID;

public class PizzaDto {
    private UUID id;
    private String name;
    private String description;
    private BigDecimal price;

    // Getters y Setters
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }
}
