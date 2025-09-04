package com.attendance.monitoring.faculty.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class FacultySignupDto {

    private String name;
    private String email;
    private String designation;
    private String uniqueId;
    private String password;

}
