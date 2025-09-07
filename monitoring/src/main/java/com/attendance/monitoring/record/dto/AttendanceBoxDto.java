package com.attendance.monitoring.record.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class AttendanceBoxDto {
    
    private String subjectId;
    private String studentId;
    private String teacherId;
    private String isPresent;
    private String periodNumber;
    private String timeOfAttendance;
    private LocalDateTime date;
    private String day;//retrive from time table and validate from server date and time
    private String roomNumber;//same as scanner number
    private String semester;
    private String year;
    private String universityId;
    private String department;
    private String section;
   
}
