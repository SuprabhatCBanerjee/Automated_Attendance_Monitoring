package com.attendance.monitoring.subject.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class TimeTableBoxDto {
    
    // private String roomNumber;//same as scanner number
    // private String numberOfClasses;
    // private String section;
    // private String department;
    private String day;
    private List<TimeTableDto> timeTable = new ArrayList<>();
}
