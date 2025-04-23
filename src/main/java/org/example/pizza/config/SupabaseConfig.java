package org.example.pizza.config;

import io.supabase.SupabaseClient;
import io.supabase.createClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class SupabaseConfig {

    @Value("${supabase.url}")
    private String supabaseUrl;

    @Value("${supabase.key}")
    private String supabaseKey;

    private final Environment env;

    public SupabaseConfig(Environment env) {
        this.env = env;
    }

    @Bean
    public SupabaseClient supabaseClient() {
        String url = supabaseUrl;
        String key = supabaseKey;

        if (url == null || url.isEmpty() || url.startsWith("${")) {
            // Asigna directamente los valores por defecto en lugar de usar env.getProperty
            url = "https://hpragblnjljgfulmzfka.supabase.co";
            key = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImhwcmFnYmxuamxqZ2Z1bG16ZmthIiwicm9sZSI6ImFub24iLCJpYXQiOjE3NDU0MTg5NjYsImV4cCI6MjA2MDk5NDk2Nn0.xyIL2vl50yz36jBIJzvtNbyTkt4cgiCK7tq-BlJt_Y8";
        }

        if (url == null || key == null) {
            throw new IllegalStateException("Supabase URL and key must be provided");
        }

        return createClient(url, key);
    }
}