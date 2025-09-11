package com.attendance.monitoring.leave.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attendance.monitoring.leave.dto.StudentLeaveDto;
import com.attendance.monitoring.leave.enums.LeaveStatusEnum;
import com.attendance.monitoring.leave.mapper.StudentLeaveMapper;
import com.attendance.monitoring.leave.model.StudentLeaveModel;
import com.attendance.monitoring.leave.repository.StudentLeaveRepository;
import com.attendance.monitoring.leave.service.StudentLeaveService;

@Service
public class StudentLeaveServiceImpl implements StudentLeaveService{

    @Autowired
    private StudentLeaveRepository studentLeaveRepository;

    @Autowired
    private StudentLeaveMapper studentLeaveMapper;

    @Override
    public boolean applyLeave(StudentLeaveDto leaveDto) {
        try {
            if(leaveDto == null) return false;
            
            leaveDto.setStatus(LeaveStatusEnum.PENDING);
            StudentLeaveModel leaveModel = this.studentLeaveMapper.toEntity(leaveDto);
            this.studentLeaveRepository.save(leaveModel);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public StudentLeaveDto getLeaveById(String id) {
        try {
            StudentLeaveModel leaveModel = this.studentLeaveRepository.findByLeaveId(id);
            StudentLeaveDto leaveDto = this.studentLeaveMapper.toDto(leaveModel);
            return leaveDto;
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public List<StudentLeaveDto> getAllLeave() {
        try {
            List<StudentLeaveModel> leaveModels = this.studentLeaveRepository.findAll();

            List<StudentLeaveDto> leaveDtos = leaveModels.stream().map(this.studentLeaveMapper::toDto).collect(Collectors.toList());

            return leaveDtos;
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            return null;
        }
    }
}
