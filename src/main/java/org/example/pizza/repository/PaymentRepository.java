package org.example.pizza.repository;

import io.supabase.SupabaseClient;
import io.supabase.data.PostgrestResponse;
import org.example.pizza.model.Payment;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Repository
public class PaymentRepository {

    private final SupabaseClient supabaseClient;

    public PaymentRepository(SupabaseClient supabaseClient) {
        this.supabaseClient = supabaseClient;
    }

    public Payment save(Payment payment) {
        Map<String, Object> payload = Map.of(
                "order_id", payment.getOrderId().toString(),
                "amount", payment.getAmount(),
                "method", payment.getMethod()
        );
        PostgrestResponse response = supabaseClient
                .from("payments")
                .insert(payload)
                .single()
                .execute();

        Map<String, Object> data = (Map<String, Object>) response.getData();
        payment.setId(UUID.fromString((String) data.get("id")));
        payment.setStatus((String) data.get("status"));
        payment.setTransactionId((String) data.get("transaction_id"));
        payment.setCreatedAt(ZonedDateTime.parse((String) data.get("created_at")));
        return payment;
    }

    public Optional<Payment> findById(UUID id) {
        PostgrestResponse response = supabaseClient
                .from("payments")
                .select()
                .eq("id", id.toString())
                .single()
                .execute();

        if (response.getData() == null) return Optional.empty();
        Map<String, Object> data = (Map<String, Object>) response.getData();
        Payment payment = new Payment();
        payment.setId(UUID.fromString((String) data.get("id")));
        payment.setOrderId(UUID.fromString((String) data.get("order_id")));
        payment.setAmount(new BigDecimal(data.get("amount").toString()));
        payment.setMethod((String) data.get("method"));
        payment.setStatus((String) data.get("status"));
        payment.setTransactionId((String) data.get("transaction_id"));
        payment.setCreatedAt(ZonedDateTime.parse((String) data.get("created_at")));
        return Optional.of(payment);
    }
}
