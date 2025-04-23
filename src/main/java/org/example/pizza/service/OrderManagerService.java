package org.example.pizza.service;

import org.example.pizza.model.Order;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrderManagerService {

    private final Map<UUID, Order> orders = new HashMap<>();

    public Order placeOrder(Order order) {
        order.setId(UUID.randomUUID());
        orders.put(order.getId(), order);
        return order;
    }

    public Optional<Order> getOrder(UUID id) {
        return Optional.ofNullable(orders.get(id));
    }

    public List<Order> getAllOrders() {
        return new ArrayList<>(orders.values());
    }

    public boolean cancelOrder(UUID id) {
        return orders.remove(id) != null;
    }
}
