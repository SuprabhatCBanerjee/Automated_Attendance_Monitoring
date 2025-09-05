package com.attendance.monitoring.record;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class AttendanceRecord {
    private int id;
    private String studentId;
    private String facultyId;
    private String subjectId;
    private String timeOfAttendance;
    private String periodNumber;//take from time table with the of timeofattendance
    private String day;//retrive from time table and validate from server date and time
    private String roomNumber;//same as scanner number
    private String department;
    private String section;
    private Boolean isPresent;
}
