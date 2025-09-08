package com.attendance.monitoring.scanner.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attendance.monitoring.record.dto.AttendanceBoxDto;
import com.attendance.monitoring.record.service.AttendanceService;
import com.attendance.monitoring.scanner.dto.ScannerDto;
import com.attendance.monitoring.scanner.service.ScannerService;
import com.attendance.monitoring.student.dto.StudentRecordDto;
import com.attendance.monitoring.subject.dto.TimeTableWrapperDto;
import com.attendance.monitoring.subject.service.TimeTableService;

@Service
public class ScannerServiceImpl implements ScannerService {

    @Autowired
    private AttendanceService attendanceService;

    @Autowired
    private TimeTableService timeTableService;

    @Override
    public boolean recordAttendance(ScannerDto scannerDto) {
        
        try {
            //time table work here go to controller for logic building

            List<AttendanceBoxDto> attendanceBoxDtos = new ArrayList<>();
            
            List<StudentRecordDto> studentRecordDtos = scannerDto.getStudents();

            TimeTableWrapperDto tableWrapperDto = timeTableService.getTimeTable(scannerDto.getUniversityId(), scannerDto.getScannerNumber(), scannerDto.getDepartment(), null);
           

            // SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
            // String date = dateFormat.toString();

            for(StudentRecordDto recordDto : studentRecordDtos){

                AttendanceBoxDto boxDto = new AttendanceBoxDto();

                boxDto.setDate(LocalDateTime.now());
                boxDto.setDay(null);
                boxDto.setDepartment(null);
                boxDto.setIsPresent(null);
                boxDto.setPeriodNumber(null);
                boxDto.setRoomNumber(scannerDto.getScannerNumber());
                boxDto.setSection(null);
                boxDto.setSemester(null);
                boxDto.setStudentId(recordDto.getStudentId());
                // boxDto.
                boxDto.setSubjectId(null);
                boxDto.setTeacherId(null);
                boxDto.setTimeOfAttendance(scannerDto.getTimeOfReceive());
                boxDto.setUniversityId(scannerDto.getUniversityId());
                boxDto.setYear(null);
                
                attendanceBoxDtos.add(boxDto);
            }
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
    }
}
