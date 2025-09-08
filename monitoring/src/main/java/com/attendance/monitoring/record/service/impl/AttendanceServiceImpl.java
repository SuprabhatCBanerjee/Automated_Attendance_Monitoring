package com.attendance.monitoring.record.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attendance.monitoring.record.dto.AttendanceBoxDto;
import com.attendance.monitoring.record.mapper.AttendanceBoxMapper;
import com.attendance.monitoring.record.model.AttendanceBox;
import com.attendance.monitoring.record.repository.AttendanceBoxRepository;
import com.attendance.monitoring.record.service.AttendanceService;

@Service
public class AttendanceServiceImpl implements AttendanceService{

    @Autowired
    private AttendanceBoxMapper attendanceBoxMapper;

    @Autowired
    private AttendanceBoxRepository attendanceBoxRepository;

    @Override
    public boolean saveAttendance(List<AttendanceBoxDto> dtos) {

        try {
            List<AttendanceBox> attendanceBoxs = dtos.stream().map(attendanceBoxMapper::toEntity).collect(Collectors.toList());
            
            this.attendanceBoxRepository.saveAll(attendanceBoxs);
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
    }
}
