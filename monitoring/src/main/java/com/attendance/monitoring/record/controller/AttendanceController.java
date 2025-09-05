package com.attendance.monitoring.record.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AttendanceController {
    
    @PostMapping("/room/roll")
    public String recordAttendance() {
        
        //each department have multiple  section which leads make different timetable for each section
        //from given room number find the time table first
        //then find teacher ==> the valid student present time
        //then push the attendance
        
        return null;
    }
    
}
