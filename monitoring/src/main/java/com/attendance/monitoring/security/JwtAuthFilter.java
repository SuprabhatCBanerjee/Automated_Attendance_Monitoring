package com.attendance.monitoring.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.attendance.monitoring.faculty.service.FacultyLoginDetailsService;
import com.attendance.monitoring.student.service.StudentLoginDetailsService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {

    @Autowired
    private JwtService jwtService;  // helper class for parsing/validating JWT

    @Autowired
    private StudentLoginDetailsService studentLoginDetailsService;

    @Autowired
    private FacultyLoginDetailsService facultyLoginDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");
        String token = null;
        String username = null;
        String role = null;

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            token = authHeader.substring(7);
            try {
                username = jwtService.extractUsername(token);
                role = jwtService.extractRole(token); //  make sure your JWT contains a "role" claim
            } catch (Exception e) {
                logger.error("JWT parsing error: " + e.getMessage());
            }
        }

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = null;

            if ("STUDENT".equalsIgnoreCase(role)) {
                userDetails = studentLoginDetailsService.loadUserByUsername(username);
            } else if ("FACULTY".equalsIgnoreCase(role)) {
                userDetails = facultyLoginDetailsService.loadUserByUsername(username);
            }

            if (userDetails != null && jwtService.validateToken(token, userDetails)) {
                UsernamePasswordAuthenticationToken authToken =
                        new UsernamePasswordAuthenticationToken(
                                userDetails, null, userDetails.getAuthorities());

                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }

        filterChain.doFilter(request, response);
    }
}
