package com.attendance.monitoring.subject.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Document
public class TimeTableModel {
    
    private String id;
    private String subjectId;
    private String facultyId;
    private String periodNumber;
    private String classStart;
    private String classEnd;

}
