package com.attendance.monitoring.faculty.model;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class FacultyModel {

    private int id;
    private String name;
    private String email;
    private String designation;
    private String uniqueId;
    private String password;
    
    private ArrayList<String> subjects; //may teach multiple subject
    private ArrayList<String> roles;// may have multiple roles like club member etc...

    
}
