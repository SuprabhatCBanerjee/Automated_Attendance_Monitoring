package com.attendance.monitoring.subject.dto;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class TimeTableWrapperDto {

    private String roomNumber;
    private String numberOfClasses;
    private String section;
    private String department;
    private String year;

    private ArrayList<TimeTableBoxDto> weeklyRoutine;
    
}
