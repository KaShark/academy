package com.kashark.crazykashark.service.impl;

import com.kashark.crazykashark.dto.StaffDTO;
import com.kashark.crazykashark.entity.Staff;
import com.kashark.crazykashark.exception.ServiceException;
import com.kashark.crazykashark.service.StaffService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class StaffServiceImplTest {
    @Autowired
    private StaffService staffService;

    @Test
    void getStaff() {
        log.info(staffService.getStaff(1, 10).toString());
    }

    @Test
    void getStaffById() throws ServiceException {
        log.info(staffService.getStaffById(1).toString());
    }

    @Test
    void getStaffByStaffId() throws ServiceException {
        log.info(staffService.getStaffByStaffId(1001).toString());
    }

    @Test
    void newStaff() throws ServiceException {
        StaffDTO staffDTO = new StaffDTO();
        staffDTO.setStaffId(1003);
        staffDTO.setStaffName("孟老师");
        staffDTO.setAuthorization(2);
        staffService.newStaff(staffDTO);
        log.info("SUCCESS");
    }

    @Test
    void editStaff() throws ServiceException {
        StaffDTO staffDTO = new StaffDTO();
        staffDTO.setId(-493891582);
        staffDTO.setAuthorization(1);
        staffService.editStaff(staffDTO);
        log.info("SUCCESS");
    }

    @Test
    void deleteStaff() throws ServiceException {
        staffService.deleteStaff(3);
        log.info("SUCCESS");
    }

    @Test
    void searchStaff() {
        log.info(staffService.searchStaff(new String[]{"老师"}, 1 ,10).toString());
    }
}