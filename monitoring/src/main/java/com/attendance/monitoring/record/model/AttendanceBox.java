package com.attendance.monitoring.record.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Document("attendance")
public class AttendanceBox {
    
    @Id
    private String id;
    
    private String subjectId;
    private String studentId;
    private String teacherId;
    private Boolean isPresent;
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
