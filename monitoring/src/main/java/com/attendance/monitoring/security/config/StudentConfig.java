package com.attendance.monitoring.security.config;


    

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.attendance.monitoring.faculty.service.FacultyLoginDetailsService;
import com.attendance.monitoring.security.JwtAuthFilter;
import com.attendance.monitoring.student.service.StudentLoginDetailsService;

//import com.task.management.service.LoginDetailsService;

@Configuration
public class StudentConfig {

    @Autowired
    private StudentLoginDetailsService studentLoginDetailsService;

    @Autowired
    private FacultyLoginDetailsService facultyLoginDetailsService;

    @Autowired
    private JwtAuthFilter jwtAuthFilter;

    //
    // @Autowired
    // private LoginDetailsService loginDetailsService;


    //
    // @Bean
    // public UserDetailsService userDetailsService(){
        // UserDetails userDetails = User
        //                             .builder()
        //                             .username("root")
        //                             .password(passwordEncoder().encode("admin")).roles("ADMIN")
        //                             .build();

        // UserDetails userDetails = null;

        // return new InMemoryUserDetailsManager(userDetails);
        // return null;
    // }
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(combinedUserDetailsService());
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }
    //
    @Bean
    public UserDetailsService combinedUserDetailsService() {
        return username -> {
            try {
                return studentLoginDetailsService.loadUserByUsername(username);
            } catch (UsernameNotFoundException e) {
                return facultyLoginDetailsService.loadUserByUsername(username);
            }
        };
    }
    //
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    //
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception{
        return builder.getAuthenticationManager();
    }
    
}

