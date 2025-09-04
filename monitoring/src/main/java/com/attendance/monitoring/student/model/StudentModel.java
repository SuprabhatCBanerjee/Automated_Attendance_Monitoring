package com.attendance.monitoring.student.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Document("student")
public class StudentModel {

    @Id
    private String id;
    private String name;
    private String address;
    private String email;
    private String phone;
    private String studentPhoto;
    private String uniqueRollNumber;
    private String password;
    private String department;//or courses
    private int year;
    private int semester;
    private String courseName;
    private String coursePeriod;// if a course is 4 year program then ===> [year of addmission --> year of passing]
}
