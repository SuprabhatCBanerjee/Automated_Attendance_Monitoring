package com.attendance.monitoring.scanner.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.attendance.monitoring.scanner.dto.ScannerDto;
import com.attendance.monitoring.scanner.service.ScannerService;
import com.attendance.monitoring.student.dto.StudentRecordDto;




@RestController
@RequestMapping("/public")
public class ScannerController {
    /**
     * on api call ==> abc.in/attendance/record <===> type POST
     * step 1 => data packet look like
     * {
     *      "scannerNumber" : "SCNR_123", //same as room number
     *      "timeOfRecord" : "10:35"//am
     *      "students" :[
     *          {
     *              "studentId" : "stud_1234",
     *              "validationCount" : "7", //min 6 let
     *              "classIn" : "10:02",
     *              "classOut" : "10:40"// or last seen in that period
     *          }
     *      ] 
     * }
     * 
     * //now we got data of first period on server ==> server works
     * 
     * step2 : fetch timetable ==> subjectId, facultyId, day, class time using room number
     * step3 : from fetch data we do some validation like period number finding,
     *         day validation , etc as required
     * step4 : after doing all the validation work server finally push data to database
     * 
     * step5 : all things works on offline server,
     *         in the night or as client requirements we push data to cloud server  
     */

     @Autowired
     private ScannerService scannerService;

     @GetMapping("/student/get-record")
     public ResponseEntity<ScannerDto> getRecord() {

        ScannerDto dto = new ScannerDto();

        dto.setScannerNumber("ROOM_206");
        dto.setTimeOfReceive("10:35");

        ArrayList<StudentRecordDto> students = new ArrayList<>();

        StudentRecordDto studentRecordDto1 = new StudentRecordDto();
        studentRecordDto1.setStudentId("STU_12DA4");
        studentRecordDto1.setValidationCount("8");
        studentRecordDto1.setClassIn("10:02");
        studentRecordDto1.setClassOut("10:42");

        StudentRecordDto studentRecordDto2 = new StudentRecordDto();
        studentRecordDto2.setStudentId("STU_12DA5");
        studentRecordDto2.setValidationCount("6");
        studentRecordDto2.setClassIn("10:05");
        studentRecordDto2.setClassOut("10:40");

        students.add(studentRecordDto1);
        students.add(studentRecordDto2);
        dto.setStudents(students);

        return new ResponseEntity<>(dto, HttpStatus.OK);
     }


     @PostMapping("/student/record")
     public ResponseEntity<String> takeAttendance(@RequestBody ScannerDto dto) {
         
        try {
            this.scannerService.recordAttendance(dto);
            return new ResponseEntity<>("Success",HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Failed",HttpStatus.FORBIDDEN);
        }

         
     }
     
     
     
     
}
