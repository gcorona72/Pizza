package org.example.pizza.ui;

import org.example.pizza.service.AuthenticatorService;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class RegisterWindow extends JFrame {
    private final AuthenticatorService authService;

    public RegisterWindow(AuthenticatorService authService) {
        this.authService = authService;
        setTitle("PizzaApp - Register");
        setSize(300, 250);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        initComponents();
    }

    private void initComponents() {
        JPanel panel = new JPanel(new GridLayout(4, 2));
        JTextField userField = new JTextField();
        JTextField emailField = new JTextField();
        JPasswordField passField = new JPasswordField();
        JButton btnRegister = new JButton("Register");

        panel.add(new JLabel("Username:"));
        panel.add(userField);
        panel.add(new JLabel("Email:"));
        panel.add(emailField);
        panel.add(new JLabel("Password:"));
        panel.add(passField);
        panel.add(new JLabel());
        panel.add(btnRegister);

        btnRegister.addActionListener(e -> {
            try {
                authService.signUp(emailField.getText(),
                        new String(passField.getPassword()));
                JOptionPane.showMessageDialog(this,
                        "Registro exitoso", "OK", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this,
                        "Error: " + ex.getMessage(), "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        add(panel);
    }
}
