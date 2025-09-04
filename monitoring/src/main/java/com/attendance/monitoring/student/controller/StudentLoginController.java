package com.attendance.monitoring.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.attendance.monitoring.student.dto.StudentLoginDto;
import com.attendance.monitoring.utility.JwtUtil;


@RestController
@RequestMapping("/public")
@CrossOrigin
public class StudentLoginController {
    
    // @Autowired
    // private UserDetailsService userDetailsService;

    // @Autowired
    // private AuthenticationManager authenticationManager;

    // @Autowired 
    // private JwtUtil jwtUtil;

    // // @Autowired
    // // private StudentService studentService;

    // @PostMapping("/login")
    // public String login(@RequestBody StudentLoginDto dto) {
        
    //     this.doAuthenticate(dto.getUniqueRollNumber(), dto.getPassword());

    //     UserDetails userDetails = userDetailsService.loadUserByUsername(dto.getUniqueRollNumber());

    //     String token = this.jwtUtil.generateToken(userDetails); 
        
    //     return token;
    // }


    // public void doAuthenticate(String uniqueRoll, String password){
        
    //     UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(uniqueRoll, password);

    //     try {
    //         authenticationManager.authenticate(authentication);
    //     } catch (Exception e) {
    //         throw new BadCredentialsException("Invalid Username or password");
    //     }
    // }

    // @ExceptionHandler(BadCredentialsException.class)
    // public String exceptionHandler(){
    //     return "Invalid Credentials";
    // }
    
}
