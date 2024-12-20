package com.salon.booking.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Disable CSRF protection (for APIs)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/user/**").permitAll() // Allow unauthenticated access to the register endpoint
                        .anyRequest().authenticated() // All other requests should require authentication
                )
                .httpBasic(Customizer.withDefaults()); // Enable Basic Authentication without any lambda

        return http.build();
    }
}
