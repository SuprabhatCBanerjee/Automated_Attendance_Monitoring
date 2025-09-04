package com.attendance.monitoring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.attendance.monitoring.faculty.dto.FacultyLoginDto;
import com.attendance.monitoring.faculty.service.FacultyLoginDetailsService;
import com.attendance.monitoring.security.JwtService;
import com.attendance.monitoring.student.dto.StudentLoginDto;
import com.attendance.monitoring.student.service.StudentLoginDetailsService;

@RestController
@RequestMapping("/public")
public class AuthController {
    
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private StudentLoginDetailsService studentLoginDetailsService;

    @Autowired
    private FacultyLoginDetailsService facultyLoginDetailsService;


    
    // Student login
    @PostMapping("/student/login")
    public String studentLogin(@RequestBody StudentLoginDto request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUniqueRollNumber(), request.getPassword())
        );

        UserDetails user = studentLoginDetailsService.loadUserByUsername(request.getUniqueRollNumber());
        String token = jwtService.generateToken(user, "STUDENT");
        //System.out.println(token);
        return token;
        // return ResponseEntity.ok(Map.of("jwt", token));
    }

    // Faculty login
    @PostMapping("/faculty/login")
    public String facultyLogin(@RequestBody FacultyLoginDto request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUniqueId(), request.getPassword())
        );

        UserDetails user = facultyLoginDetailsService.loadUserByUsername(request.getUniqueId());
        String token = jwtService.generateToken(user, "FACULTY");

        return token;
        // return ResponseEntity.ok(Map.of("jwt", token));
    }
}
