package com.attendance.monitoring.security.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.attendance.monitoring.security.JwtAuthEntryPoint;
import com.attendance.monitoring.security.JwtAuthFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    //
    @Autowired
    private JwtAuthEntryPoint point;

    @Autowired
    private JwtAuthFilter filter;
    
    //
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        
        http
            .cors(c -> c.configure(http))
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> 
                auth
                    .requestMatchers("/public/**").permitAll()
                    .requestMatchers("/auth/**").authenticated()
                    .anyRequest().authenticated()
            )
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .exceptionHandling(ex -> ex.authenticationEntryPoint(point));
        
            http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}

