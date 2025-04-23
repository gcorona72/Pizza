package org.example.pizza.service;

import io.supabase.SupabaseClient;
import io.supabase.data.auth.AuthResponse;
import io.supabase.data.auth.Session;
import io.supabase.exception.SupabaseException;
import org.springframework.stereotype.Service;

@Service
public class AuthenticatorService {

    private final SupabaseClient supabaseClient;

    public AuthenticatorService(SupabaseClient supabaseClient) {
        this.supabaseClient = supabaseClient;
    }

    public Session signIn(String email, String password) throws SupabaseException {
        AuthResponse response = supabaseClient.auth().signIn(email, password);
        if (response.getSession() == null) {
            throw new SupabaseException("Sign in failed");
        }
        return response.getSession();
    }

    public void signOut(String accessToken) throws SupabaseException {
        supabaseClient.auth().signOut(accessToken);
    }

    public Session signUp(String email, String password) throws SupabaseException {
        AuthResponse response = supabaseClient.auth().signUp(email, password);
        if (response.getSession() == null) {
            throw new SupabaseException("Sign up failed");
        }
        return response.getSession();
    }
}
