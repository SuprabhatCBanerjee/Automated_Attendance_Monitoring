package com.attendance.monitoring.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.attendance.monitoring.student.dto.StudentSignupDto;
import com.attendance.monitoring.student.service.StudentService;


@RestController
@RequestMapping("/public")
@CrossOrigin
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @GetMapping("/test")
    public String test() {
        StudentSignupDto dto = new StudentSignupDto();
        dto.setName("yo hooman");
        dto.setEmail("hooman@noman.yl");
        dto.setDepartment("BokaLoca");
        dto.setPhone("123-654-879");
        dto.setUniqueRollNumber("11900223012");
        dto.setPassword(passwordEncoder.encode("teamboga"));
        studentService.doStudentSignup(dto);
        return "hello world of attendance";
    }
    
}
