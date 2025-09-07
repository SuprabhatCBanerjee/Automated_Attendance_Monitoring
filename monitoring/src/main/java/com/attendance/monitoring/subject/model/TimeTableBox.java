package com.attendance.monitoring.subject.model;

import java.util.ArrayList;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Document
public class TimeTableBox {
    private String id;
    private String day;
    private ArrayList<TimeTableModel> timeTable;

    public void addTimeTable(TimeTableModel tableModel){
        this.timeTable.add(tableModel);
    }
}
