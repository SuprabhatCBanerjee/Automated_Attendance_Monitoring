package com.attendance.monitoring.subject.model;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class TimeTableBox {
    private String id;
    private ArrayList<TimeTableModel> timeTable;

    public void addTimeTable(TimeTableModel tableModel){
        this.timeTable.add(tableModel);
    }
}
