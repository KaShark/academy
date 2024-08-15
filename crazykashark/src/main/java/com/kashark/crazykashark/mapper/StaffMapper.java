package com.kashark.crazykashark.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kashark.crazykashark.dto.StaffDTO;
import com.kashark.crazykashark.entity.Staff;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 员工信息Mapper
 * @author 赵宇鹏
 * @version 1.0
 */
@Mapper
public interface StaffMapper extends BaseMapper<Staff> {
    List<StaffDTO> getStaff(Integer start, Integer length);

    StaffDTO getStaffById(Integer id);

    StaffDTO getStaffByStaffId(Integer staffId);

    List<StaffDTO> searchStaff(String[] keywords, Integer start, Integer length);
}
