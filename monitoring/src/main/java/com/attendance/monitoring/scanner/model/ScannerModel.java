package com.attendance.monitoring.scanner.model;

import java.util.ArrayList;

import com.attendance.monitoring.student.model.StudentRecordModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ScannerModel {
    private String id;
    private String scannerNumber;//same as room number
    private String timeOfReceive;
    private ArrayList<StudentRecordModel> students;

    public void addStudents(StudentRecordModel recordModel){
        this.students.add(recordModel);
    }

}
