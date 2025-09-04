package com.attendance.monitoring.subject.model;

import java.util.ArrayList;

public class TimeTableModel {
    
    private String id;
    private String roomNumber;
    private String numberOfClasses;
    private String section;
    private String department;
    private ArrayList<String> subjectIds;
    private ArrayList<String> facultyIds;

    private ArrayList<String[]> classTime;

}
