package com.attendance.monitoring.student.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class StudentRecordModel {
    private String id;
    private String studentId;
    private String validationCount;
    private String classIn;
    private String classOut;
}
