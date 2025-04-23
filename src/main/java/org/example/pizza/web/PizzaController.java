package org.example.pizza.web;

import org.example.pizza.model.Pizza;
import org.example.pizza.service.OrderManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pizzas")
public class PizzaController {

    private final OrderManagerService orderService;

    @Autowired
    public PizzaController(OrderManagerService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<Pizza> getAllPizzas() {
        return orderService.getAllPizzas();
    }
}
