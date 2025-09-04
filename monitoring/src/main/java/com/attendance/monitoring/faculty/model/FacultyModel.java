package com.attendance.monitoring.faculty.model;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Document("faculty")
public class FacultyModel {

    @Id
    private String id;
    private String name;
    private String email;
    private String designation;
    private String uniqueId;
    private String password;
    //university of college id
    private ArrayList<String> subjects; //may teach multiple subject
    private ArrayList<String> roles;// may have multiple roles like club member etc...

    
}
