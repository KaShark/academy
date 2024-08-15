package com.kashark.crazykashark.mapper;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class StaffMapperTest {
    @Autowired
    private StaffMapper staffMapper;

    @Test
    void getStaff() {
        log.info(staffMapper.getStaff(0, 10).toString());
    }

    @Test
    void getStaffById() {
        log.info(staffMapper.getStaffById(1).toString());
    }

    @Test
    void getStaffByStaffId() {
        log.info(staffMapper.getStaffByStaffId(1001).toString());
    }

    @Test
    void searchStaff() {
        log.info(staffMapper.searchStaff(new String[]{"楚"}, 0, 10).toString());
    }
}