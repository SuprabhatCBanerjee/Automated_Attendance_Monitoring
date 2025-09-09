package com.attendance.monitoring.scanner.service.impl;

import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attendance.monitoring.record.dto.AttendanceBoxDto;
import com.attendance.monitoring.record.service.AttendanceService;
import com.attendance.monitoring.scanner.dto.ScannerDto;
import com.attendance.monitoring.scanner.service.ScannerService;
import com.attendance.monitoring.student.dto.StudentRecordDto;
import com.attendance.monitoring.subject.dto.TimeTableBoxDto;
import com.attendance.monitoring.subject.dto.TimeTableDto;
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
            LocalDateTime dateTime = LocalDateTime.now();

            String day = dateTime.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);

            List<AttendanceBoxDto> attendanceBoxDtos = new ArrayList<>();
            
            List<StudentRecordDto> studentRecordDtos = scannerDto.getStudents();

            TimeTableWrapperDto tableWrapperDto = timeTableService.getTimeTable(scannerDto.getUniversityId(), scannerDto.getScannerNumber(), scannerDto.getDepartment());
            
            List<TimeTableBoxDto> timeTableBoxDto = tableWrapperDto.getWeeklyRoutine();//contains one weeks routine

            List<TimeTableDto> periods = timeTableService.getDailyRoutine(timeTableBoxDto, day.toUpperCase());// contains one day routine

            TimeTableDto onePeriod = timeTableService.getOnePeriod(periods, scannerDto.getTimeOfReceive());

            for(StudentRecordDto recordDto : studentRecordDtos){

                AttendanceBoxDto boxDto = new AttendanceBoxDto();

                boxDto.setDate(LocalDateTime.now());
                boxDto.setDay(day);
                boxDto.setDepartment(tableWrapperDto.getDepartment());
                boxDto.setIsPresent(true);
                boxDto.setPeriodNumber(onePeriod.getPeriodNumber());
                boxDto.setRoomNumber(scannerDto.getScannerNumber());
                boxDto.setSection(tableWrapperDto.getSection());
                boxDto.setSemester(tableWrapperDto.getSemester());
                boxDto.setStudentId(recordDto.getStudentId());
                boxDto.setSubjectId(onePeriod.getSubjectId());
                boxDto.setTeacherId(onePeriod.getFacultyId());
                boxDto.setTimeOfAttendance(scannerDto.getTimeOfReceive());
                boxDto.setUniversityId(scannerDto.getUniversityId());
                boxDto.setYear(tableWrapperDto.getYear());
                
                attendanceBoxDtos.add(boxDto);
            }

            this.attendanceService.saveAttendance(attendanceBoxDtos);
           
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
    }
}
