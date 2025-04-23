package org.example.pizza.web;

import org.example.pizza.model.Payment;
import org.example.pizza.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public PaymentDto processPayment(@RequestBody ProcessPaymentRequest request) {
        Payment payment = paymentService.processPayment(request.getOrderId(), request.getAmount(), request.getMethod());

        PaymentDto dto = new PaymentDto();
        dto.setId(payment.getId());
        dto.setOrderId(payment.getOrderId());
        dto.setAmount(payment.getAmount());
        dto.setMethod(payment.getMethod());
        dto.setStatus(payment.getStatus());
        dto.setTransactionId(payment.getTransactionId());
        dto.setCreatedAt(payment.getCreatedAt());
        return dto;
    }

    @GetMapping("/{id}")
    public PaymentDto getPayment(@PathVariable UUID id) {
        Payment payment = paymentService.getPayment(id);

        PaymentDto dto = new PaymentDto();
        dto.setId(payment.getId());
        dto.setOrderId(payment.getOrderId());
        dto.setAmount(payment.getAmount());
        dto.setMethod(payment.getMethod());
        dto.setStatus(payment.getStatus());
        dto.setTransactionId(payment.getTransactionId());
        dto.setCreatedAt(payment.getCreatedAt());
        return dto;
    }
}
