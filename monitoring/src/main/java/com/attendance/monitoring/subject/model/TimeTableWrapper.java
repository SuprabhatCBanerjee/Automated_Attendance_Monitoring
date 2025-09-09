package com.attendance.monitoring.subject.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Document("timetables")
public class TimeTableWrapper {
    
    @Id
    private String id;
    private String roomNumber;//same as scanner number
    private String numberOfClasses;
    private String section;
    private String department;
    private String year;
    private String universityId;
    private String semester;

    private List<TimeTableBox> weeklyRoutine = new ArrayList<>();

    // public void addTimeTableBox(TimeTableBox box){
    //     this.weeklyRoutine.add(box);
    // }
    
}
