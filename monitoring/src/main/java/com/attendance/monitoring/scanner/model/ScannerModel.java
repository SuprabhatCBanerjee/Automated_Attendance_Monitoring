package com.attendance.monitoring.scanner.model;

import java.util.ArrayList;

import com.attendance.monitoring.student.model.StudentRecordModel;

public class ScannerModel {
    private String id;
    private String scannerNumber;//same as room number
    private String timeOfReceive;
    private ArrayList<StudentRecordModel> students;

}
