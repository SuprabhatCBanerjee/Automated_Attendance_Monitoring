package com.attendance.monitoring.subject.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor


public class TimeTableBox {
    private String id;
    private String day;
    private List<TimeTableModel> timeTable = new ArrayList<>();

    // public void addTimeTable(TimeTableModel tableModel){
    //     this.timeTable.add(tableModel);
    // }
}
