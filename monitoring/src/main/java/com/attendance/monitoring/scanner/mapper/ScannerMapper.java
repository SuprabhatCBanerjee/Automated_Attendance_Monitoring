package com.attendance.monitoring.scanner.mapper;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.attendance.monitoring.scanner.dto.ScannerDto;
import com.attendance.monitoring.scanner.model.ScannerModel;
import com.attendance.monitoring.student.dto.StudentRecordDto;
import com.attendance.monitoring.student.model.StudentRecordModel;

@Component
public class ScannerMapper {

    //toEntity
    public ScannerModel toEntity(ScannerDto dto){
        ScannerModel model = new ScannerModel();
        model.setScannerNumber(dto.getScannerNumber());
        model.setTimeOfReceive(dto.getTimeOfReceive());

        for (StudentRecordDto studentRecordDto : dto.getStudents()) {
            StudentRecordModel studentRecordModel = new StudentRecordModel();
            studentRecordModel.setStudentId(studentRecordDto.getStudentId());
            studentRecordModel.setValidationCount(studentRecordDto.getValidationCount());
            studentRecordModel.setClassIn(studentRecordDto.getClassIn());
            studentRecordModel.setClassOut(studentRecordDto.getClassOut());
            model.addStudents(studentRecordModel);
        }

        return model;
    }

    //toDto
    public ScannerDto toDto(ScannerModel model){
        ScannerDto dto = new ScannerDto();
        dto.setScannerNumber(model.getScannerNumber());
        dto.setTimeOfReceive(model.getTimeOfReceive());
        
        ArrayList<StudentRecordDto> records = new ArrayList<>();
        for(StudentRecordModel recordModel : model.getStudents()){
            StudentRecordDto studentRecordDto = new StudentRecordDto();
            studentRecordDto.setStudentId(recordModel.getStudentId());
            studentRecordDto.setValidationCount(recordModel.getValidationCount());
            studentRecordDto.setClassIn(recordModel.getClassIn());
            studentRecordDto.setClassOut(recordModel.getClassOut());
            records.add(studentRecordDto);
        }

        dto.setStudents(records);
        return dto;
    }
}
