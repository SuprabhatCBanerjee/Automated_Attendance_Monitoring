package com.attendance.monitoring.record.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class AttendanceBox {
    
    private String id;
    private String subjectId;
    private String studentId;
    private String teacherId;
    private String isPresent;
    private String classStartTime;
    private String classEndTime;
    private int semester;
    
}
