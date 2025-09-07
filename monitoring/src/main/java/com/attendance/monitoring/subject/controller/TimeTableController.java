package com.attendance.monitoring.subject.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.attendance.monitoring.subject.dto.TimeTableBoxDto;
import com.attendance.monitoring.subject.dto.TimeTableDto;
import com.attendance.monitoring.subject.dto.TimeTableWrapperDto;
import com.attendance.monitoring.subject.mapper.TimeTableWrapperMapper;
import com.attendance.monitoring.subject.model.TimeTableWrapper;
import com.attendance.monitoring.subject.service.TimeTableService;



@RestController
@RequestMapping("/public")
public class TimeTableController {

    @Autowired
    private TimeTableService tableService;
    
    @GetMapping("/misc")
    public ResponseEntity<TimeTableWrapperDto> table() {

        //wrapper > box > timetable 
        TimeTableWrapperDto tableWrapper = new TimeTableWrapperDto();

        tableWrapper.setDepartment("Bio-Medical");
        tableWrapper.setNumberOfClasses("7");
        tableWrapper.setRoomNumber("ROOM_B125A");
        tableWrapper.setYear("FIRST-YEAR");

        //box 
        ArrayList<TimeTableBoxDto> boxDtos = new ArrayList<>();

        TimeTableBoxDto boxDto1 = new TimeTableBoxDto();
        boxDto1.setDay("MONDAY");
        //
        TimeTableBoxDto boxDto2 = new TimeTableBoxDto();
        boxDto2.setDay("TUESDAY");

        //table
        ArrayList<TimeTableDto> tableDtos1 = new ArrayList<>();

        TimeTableDto tableDto1 = new TimeTableDto();
        tableDto1.setSubjectId("ENGLISH");

        tableDtos1.add(tableDto1);
        boxDto1.setTimeTable(tableDtos1);
        //bulid day 1 routine

        //table
        ArrayList<TimeTableDto> tableDtos2 = new ArrayList<>();

        TimeTableDto tableDto2 = new TimeTableDto();
        tableDto2.setSubjectId("ENGLISH");

        tableDtos2.add(tableDto1);
        boxDto2.setTimeTable(tableDtos2);
        //bulid day 2 routine

        boxDtos.add(boxDto1);
        boxDtos.add(boxDto2);
        tableWrapper.setWeeklyRoutine(boxDtos);
        return new ResponseEntity<>(tableWrapper, HttpStatus.OK);
    }

    //
    @Autowired
    private TimeTableWrapperMapper wrapperMapper;

    @PostMapping("/table")
    public ResponseEntity<TimeTableWrapperDto> table(@RequestBody TimeTableWrapperDto wrapperDto) {
        
        TimeTableWrapper wrapper = new TimeTableWrapper();
        TimeTableWrapperDto dto = new TimeTableWrapperDto();

      

        try {
            wrapper = wrapperMapper.toEntity(wrapperDto);
            System.out.println(wrapper.getRoomNumber());
            dto = wrapperMapper.toDto(wrapper);

            this.tableService.saveTable(wrapperDto);
            // System.out.println(dto.getWeeklyRoutine());
            // System.out.println(dto.getRoomNumber());
            return new ResponseEntity<>(dto, HttpStatus.OK);
        } catch (Exception e) {
            // System.out.println(e.getLocalizedMessage());
            e.printStackTrace();
            return new ResponseEntity<>(dto, HttpStatus.FAILED_DEPENDENCY);
        }
        
        // System.out.println();

        
    }
    
    
}
