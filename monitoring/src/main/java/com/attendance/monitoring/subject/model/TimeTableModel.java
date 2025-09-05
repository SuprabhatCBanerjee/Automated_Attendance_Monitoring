package com.attendance.monitoring.subject.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class TimeTableModel {
    
    private String id;
    private String roomNumber;//same as scanner number
    private String numberOfClasses;
    private String section;
    private String department;
    private String subjectId;
    private String facultyId;
    private String day;
    private String classStart;
    private String classEnd;

}
