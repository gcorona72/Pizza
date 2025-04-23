package org.example.pizza.ui;

import org.example.pizza.service.AuthenticatorService;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class LoginWindow extends JFrame {
    private final AuthenticatorService authService;

    public LoginWindow(AuthenticatorService authService) {
        this.authService = authService;
        setTitle("PizzaApp - Login");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initComponents();
    }

    private void initComponents() {
        JPanel panel = new JPanel(new GridLayout(3, 2));
        JTextField userField = new JTextField();
        JPasswordField passField = new JPasswordField();
        JButton btnLogin = new JButton("Login");

        panel.add(new JLabel("Username:"));
        panel.add(userField);
        panel.add(new JLabel("Password:"));
        panel.add(passField);
        panel.add(new JLabel());
        panel.add(btnLogin);

        btnLogin.addActionListener(e -> {
            boolean ok = authService.login(userField.getText(),
                    new String(passField.getPassword()));
            if (ok) {
                dispose();
                SwingUtilities.invokeLater(() -> {
                    MenuWindow menu = getContext().getBean(MenuWindow.class);
                    menu.setVisible(true);
                });
            } else {
                JOptionPane.showMessageDialog(this,
                        "Credenciales incorrectas", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        add(panel);
    }

    private org.springframework.context.ApplicationContext getContext() {
        return org.springframework.web.context.ContextLoader.getCurrentWebApplicationContext();
    }
}
