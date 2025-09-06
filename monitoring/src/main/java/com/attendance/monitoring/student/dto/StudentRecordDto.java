package com.attendance.monitoring.student.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class StudentRecordDto {
    private String studentId;
    private String validationCount;
    private String classIn;
    private String classOut;
}
