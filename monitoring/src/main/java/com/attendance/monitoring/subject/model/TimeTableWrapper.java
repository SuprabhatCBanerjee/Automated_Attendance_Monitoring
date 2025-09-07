package com.attendance.monitoring.subject.model;

import java.util.ArrayList;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Document
public class TimeTableWrapper {
    
    private String id;
    private String roomNumber;//same as scanner number
    private String numberOfClasses;
    private String section;
    private String department;
    private String year;

    private ArrayList<TimeTableBox> weeklyRoutine;

    public void addTimeTableBox(TimeTableBox box){
        this.weeklyRoutine.add(box);
    }
    
}
