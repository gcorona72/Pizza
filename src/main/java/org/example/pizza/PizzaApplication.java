package org.example.pizza;

import org.example.pizza.config.SupabaseConfig;
import org.example.pizza.ui.LoginWindow;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.swing.*;

@SpringBootApplication
public class PizzaApplication {

    public static void main(String[] args) {
        // Iniciar Spring
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(PizzaApplication.class);

        // Lógica Swing en Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            LoginWindow login = context.getBean(LoginWindow.class);
            login.setVisible(true);
        });
    }
}
