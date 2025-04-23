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
            url = env.getProperty("SUPABASE_URL");
            key = env.getProperty("SUPABASE_KEY");
        }

        if (url == null || key == null) {
            throw new IllegalStateException("Supabase URL and key must be provided");
        }

        return createClient(url, key);
    }
}
