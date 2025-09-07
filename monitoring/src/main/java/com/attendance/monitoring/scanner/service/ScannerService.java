package com.attendance.monitoring.scanner.service;

import com.attendance.monitoring.scanner.dto.ScannerDto;

public interface ScannerService {

    public boolean recordAttendance(ScannerDto dto);
    
} 
