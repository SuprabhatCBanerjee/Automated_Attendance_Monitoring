package com.attendance.monitoring.student.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class StudentSignupDto {
    private String name;
    private String email;
    private String phone;
    private String uniqueRollNumber;
    private String password; 
    private String department;//or 
}
