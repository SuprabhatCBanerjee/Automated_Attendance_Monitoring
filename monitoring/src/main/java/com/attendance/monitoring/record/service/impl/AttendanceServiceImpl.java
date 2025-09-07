package com.attendance.monitoring.record.service.impl;

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
    public boolean saveAttendance(AttendanceBoxDto dto) {

        try {
            AttendanceBox attendanceBox = new AttendanceBox();
            attendanceBox = attendanceBoxMapper.toEntity(dto);
            this.attendanceBoxRepository.save(attendanceBox);
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
    }
}
