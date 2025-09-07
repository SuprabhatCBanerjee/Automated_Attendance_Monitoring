package com.attendance.monitoring.scanner.dto;

import java.util.ArrayList;

import com.attendance.monitoring.student.dto.StudentRecordDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ScannerDto { 
    private String scannerNumber;//same as room number
    private String timeOfReceive;
    private String universityId;
    private ArrayList<StudentRecordDto> students;
}
