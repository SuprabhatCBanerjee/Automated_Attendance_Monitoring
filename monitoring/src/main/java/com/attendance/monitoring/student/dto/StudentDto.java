package com.attendance.monitoring.student.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDto {

    private String name;
    private String address;
    private String email;
    private String phone;
    private String studentPhoto;
    private String uniqueRollNumber;
    private String department;//or courses
    private int year;
    private int semester;
    private String courseName;
    private String coursePeriod;

}
