package org.example.pizza.repository;

import io.supabase.SupabaseClient;
import io.supabase.data.PostgrestResponse;
import org.example.pizza.model.Pizza;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class PizzaRepository {

    private final SupabaseClient supabaseClient;

    public PizzaRepository(SupabaseClient supabaseClient) {
        this.supabaseClient = supabaseClient;
    }

    public List<Pizza> findAll() {
        PostgrestResponse response = supabaseClient
                .from("pizzas")
                .select()
                .execute();

        List<Pizza> pizzas = new ArrayList<>();
        ((List<Map<String, Object>>) response.getData()).forEach(map -> {
            Pizza p = new Pizza();
            p.setId((Integer) map.get("id"));
            p.setName((String) map.get("name"));
            p.setDescription((String) map.get("description"));
            p.setPrice(new BigDecimal(map.get("price").toString()));
            p.setCreatedAt(ZonedDateTime.parse((String) map.get("created_at")));
            pizzas.add(p);
        });
        return pizzas;
    }
}
