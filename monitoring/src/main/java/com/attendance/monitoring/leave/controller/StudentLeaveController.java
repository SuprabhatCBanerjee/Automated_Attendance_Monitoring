package com.attendance.monitoring.leave.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.attendance.monitoring.leave.dto.StudentLeaveDto;
import com.attendance.monitoring.leave.enums.LeaveStatusEnum;
import com.attendance.monitoring.leave.service.StudentLeaveService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/public")
public class StudentLeaveController {
    
    @Autowired
    private StudentLeaveService leaveService;

    @GetMapping("/student/get-leave")
    public ResponseEntity<?> getLeave() {
        StudentLeaveDto leaveDto = new StudentLeaveDto();
        leaveDto.setStudentName("R. jadeja");
        leaveDto.setDescription("i am a good cricket pilayer and i was invated to the NSS ground cleaning event");
        leaveDto.setFrom("10-09-2025");
        leaveDto.setTo("15-09-2025");
        leaveDto.setStudentId("STUD-153A");
        leaveDto.setFacultyId("FAC-24A");//classteacher
        leaveDto.setLeaveId("LEV-4532");
        leaveDto.setStatus(LeaveStatusEnum.PENDING);
        return new ResponseEntity<>(leaveDto, HttpStatus.OK);
    }

    @PostMapping("/student/apply-student-leave")
    public ResponseEntity<?> applyStudentLeave(@RequestBody StudentLeaveDto leaveDto) {
        try {
            if(leaveDto == null) return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
            this.leaveService.applyLeave(leaveDto);
            return new ResponseEntity<>(true, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    
}
