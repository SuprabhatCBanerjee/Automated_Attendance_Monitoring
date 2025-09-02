package com.attendance.monitoring.student.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class StudentModel {
    private int id;
    private String name;
    private String address;
    private String email;
    private String phone;
    private String studentPhoto;
    private String uniqueRollNumber;
    private String password;
    private String department;
    private int year;
    private int semester;
    private String coursePeriod;// if a course is 4 year program then ===> [year of addmission --> year of passing]
}
