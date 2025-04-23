package org.example.pizza.web;

import org.example.pizza.model.Order;
import org.example.pizza.service.OrderManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderManagerService orderService;

    @Autowired
    public OrderController(OrderManagerService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderService.crearPedido(order);
    }

    @PutMapping("/{id}")
    public Order updateOrder(@PathVariable UUID id, @RequestBody Order order) {
        order.setId(id);
        return orderService.actualizarPedido(order);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable UUID id) {
        orderService.eliminarPedido(id);
    }
}
