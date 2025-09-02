package com.attendance.monitoring.admin.model;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class AdminModel {
    
    private int id;
    private String username;
    private String password;
    private String name;
    private String email;
    private String designation;
    
    private ArrayList<String> controls;

}
