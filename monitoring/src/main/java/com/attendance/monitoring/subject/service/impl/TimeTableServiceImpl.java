package com.attendance.monitoring.subject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attendance.monitoring.subject.dto.TimeTableWrapperDto;
import com.attendance.monitoring.subject.mapper.TimeTableWrapperMapper;
import com.attendance.monitoring.subject.model.TimeTableWrapper;
import com.attendance.monitoring.subject.repository.TimeTableRepository;
import com.attendance.monitoring.subject.service.TimeTableService;

@Service
public class TimeTableServiceImpl implements TimeTableService {

    @Autowired
    private TimeTableRepository tableRepository;

    // private TimeTableWrapperMapper wrapperMapper = new TimeTableWrapperMapper();
    @Autowired
    private TimeTableWrapperMapper wrapperMapper;

    @Override
    public TimeTableWrapper saveTable(TimeTableWrapperDto wrapperDto) {
        try {

            TimeTableWrapper wrapper = wrapperMapper.toEntity(wrapperDto);
            this.tableRepository.save(wrapper);
            return wrapper;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        
    }
}
