package com.attendance.monitoring.record;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class AttendanceRecord {
    private int id;
    private String studentId;
    private String year;
    private String department;
    private String subjectId;
    private Boolean isPresent;
}
