package com.attendance.monitoring.record.mapper;

import org.springframework.stereotype.Component;

import com.attendance.monitoring.record.dto.AttendanceBoxDto;
import com.attendance.monitoring.record.model.AttendanceBox;

@Component
public class AttendanceBoxMapper {
    
    //toEntity
    public AttendanceBox toEntity(AttendanceBoxDto dto){
       
        AttendanceBox box = new AttendanceBox();
        
        box.setRoomNumber(dto.getRoomNumber());
        box.setSubjectId(dto.getSubjectId());
        box.setStudentId(dto.getStudentId());
        box.setTeacherId(dto.getTeacherId());
        box.setDate(dto.getDate());
        box.setDay(dto.getDay());
        box.setDepartment(dto.getDepartment());
        box.setIsPresent(dto.getIsPresent());
        box.setPeriodNumber(dto.getPeriodNumber());
        box.setSection(dto.getSection());
        box.setSemester(dto.getSemester());
        box.setTimeOfAttendance(dto.getTimeOfAttendance());
        box.setUniversityId(dto.getUniversityId());
        box.setYear(dto.getYear());

        return box;
    }

    //toDto
    public AttendanceBoxDto toDto(AttendanceBox box){
        AttendanceBoxDto boxDto = new AttendanceBoxDto();

        boxDto.setRoomNumber(box.getRoomNumber());
        boxDto.setSubjectId(box.getSubjectId());
        boxDto.setStudentId(box.getStudentId());
        boxDto.setTeacherId(box.getTeacherId());
        boxDto.setDate(box.getDate());
        boxDto.setDay(box.getDay());
        boxDto.setDepartment(box.getDepartment());
        boxDto.setIsPresent(box.getIsPresent());
        boxDto.setPeriodNumber(box.getPeriodNumber());
        boxDto.setSection(box.getSection());
        boxDto.setSemester(box.getSemester());
        boxDto.setTimeOfAttendance(box.getTimeOfAttendance());
        boxDto.setUniversityId(box.getUniversityId());
        boxDto.setYear(box.getYear());

        return boxDto;
    }
}
