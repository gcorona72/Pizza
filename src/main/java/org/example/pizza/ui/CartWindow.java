package org.example.pizza.ui;

import org.example.pizza.model.Order;
import org.example.pizza.service.OrderManagerService;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class CartWindow extends JFrame {
    private final OrderManagerService orderService;
    private Order currentOrder = new Order();

    public CartWindow(OrderManagerService orderService) {
        this.orderService = orderService;
        setTitle("PizzaApp - Cart");
        setSize(400, 300);
        initComponents();
    }

    private void initComponents() {
        // Implementa lista de items, botones para actualizar, checkout...
    }
}
