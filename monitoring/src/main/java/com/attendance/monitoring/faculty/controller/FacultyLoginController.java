package com.attendance.monitoring.faculty.controller;

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

import com.attendance.monitoring.faculty.dto.FacultySignupDto;
import com.attendance.monitoring.utility.JwtUtil;

@RestController
@RequestMapping("/public")
@CrossOrigin
public class FacultyLoginController {
    
    // @Autowired
    // private UserDetailsService userDetailsService;

    // @Autowired
    // private AuthenticationManager authenticationManager;

    // @Autowired
    // private JwtUtil jwtUtil;


    // @PostMapping("/faculty/login")
    // public String login(@RequestBody FacultySignupDto dto) {
        
    //     this.doAuthenticate(dto.getUniqueId(), dto.getPassword());

    //     UserDetails userDetails = userDetailsService.loadUserByUsername(dto.getUniqueId());

    //     //String token = this.jwtUtil.generateToken(userDetails); 
        
    //     return null;
    // }


    // public void doAuthenticate(String uniqueId, String password){
        
    //     UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(uniqueId, password);

    //     try {
    //         authenticationManager.authenticate(authentication);
    //     } catch (Exception e) {
    //         throw new BadCredentialsException("Invalid Username or password");
    //     }
    // }

    // @ExceptionHandler(BadCredentialsException.class)
    // public String exceptionHandler(){
    //     return "Invalid Credentials";
    //}
}
