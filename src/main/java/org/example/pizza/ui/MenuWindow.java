package org.example.pizza.ui;

import org.example.pizza.model.Pizza;
import org.example.pizza.service.PizzaService;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.util.List;

@Component
public class MenuWindow extends JFrame {
    private final PizzaService pizzaService;

    public MenuWindow(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
        setTitle("PizzaApp - Menu");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initComponents();
    }

    private void initComponents() {
        List<Pizza> pizzas = pizzaService.getAllPizzas();
        JPanel panel = new JPanel(new GridLayout(pizzas.size(), 1));
        for (Pizza p : pizzas) {
            JButton btn = new JButton(p.toString());
            btn.addActionListener(e -> {
                // abrir ventana carrito, etc.
            });
            panel.add(btn);
        }
        add(new JScrollPane(panel));
    }
}
