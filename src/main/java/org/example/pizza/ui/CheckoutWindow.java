package org.example.pizza.ui;

import org.example.pizza.model.Order;
import org.example.pizza.service.OrderManagerService;
import org.example.pizza.service.PaymentService;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class CheckoutWindow extends JFrame {
    private final OrderManagerService orderService;
    private final PaymentService paymentService;

    public CheckoutWindow(OrderManagerService orderService,
                          PaymentService paymentService) {
        this.orderService = orderService;
        this.paymentService = paymentService;
        setTitle("PizzaApp - Checkout");
        setSize(400, 300);
        initComponents();
    }

    private void initComponents() {
        // Implementa campos de pago, botón procesar, mostrar resultado...
    }
}
