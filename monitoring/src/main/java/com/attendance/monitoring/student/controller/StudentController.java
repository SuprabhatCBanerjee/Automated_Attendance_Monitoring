package com.attendance.monitoring.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.attendance.monitoring.student.dto.StudentSignupDto;
import com.attendance.monitoring.student.service.StudentService;


@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    
    @GetMapping("/test")
    public String test() {
        StudentSignupDto dto = new StudentSignupDto();
        dto.setName("yo hooman");
        dto.setEmail("hooman@noman.yl");
        dto.setDepartment("BokaLoca");
        dto.setPhone("123-654-879");
        dto.setPassword("bhootkibegan");
        studentService.doStudentSignup(dto);
        return "hello world of attendance";
    }
    
}
