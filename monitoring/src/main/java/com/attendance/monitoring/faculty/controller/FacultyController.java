package com.attendance.monitoring.faculty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.attendance.monitoring.faculty.dto.FacultySignupDto;
import com.attendance.monitoring.faculty.service.FacultyService;


@RestController
@RequestMapping("/public")
public class FacultyController {

    @Autowired
    private FacultyService facultyService;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @GetMapping("/faculty")
    public String doSgn() {
        FacultySignupDto dto = new FacultySignupDto();
        dto.setName("dabbang");
        dto.setDesignation("profesor");
        dto.setEmail("yababy@#delt.yo");
        dto.setUniqueId("123987");
        dto.setPassword(passwordEncoder.encode("qwerty"));
        facultyService.facultySignup(dto);
        return "i am adding sign up";
    }
    
}
