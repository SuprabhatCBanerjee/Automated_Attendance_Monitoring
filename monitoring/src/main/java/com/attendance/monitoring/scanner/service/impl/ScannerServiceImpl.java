package com.attendance.monitoring.scanner.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attendance.monitoring.record.dto.AttendanceBoxDto;
import com.attendance.monitoring.record.service.AttendanceService;
import com.attendance.monitoring.scanner.dto.ScannerDto;
import com.attendance.monitoring.scanner.service.ScannerService;

@Service
public class ScannerServiceImpl implements ScannerService {

    @Autowired
    private AttendanceService attendanceService;

    @Override
    public boolean recordAttendance(ScannerDto dto) {
        
        try {
            //time table work here go to controller for logic building
            AttendanceBoxDto attendanceBoxDto = new AttendanceBoxDto();
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
    }
}
