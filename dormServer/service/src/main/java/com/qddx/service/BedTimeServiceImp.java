package com.qddx.service;

import com.qddx.dao.*;
import com.qddx.domain.BedTime;
import com.qddx.domain.Student;
import org.apache.ibatis.session.SqlSessionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description:
 * @Author: HUOHENGTONG
 * @CreateDate: 2019/4/29 12:40
 */
@Service
public class BedTimeServiceImp {
    @Autowired
    private BedTimeMapper bedTimeMapper;
    @Autowired
    private LogInfoMapper logInfoMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private DormitoryMapper dormitoryMapper;

    public String InsertBedtime(String username){
        BedTime bedTime = new BedTime();
        Integer stuid = logInfoMapper.selcetByUserNameWithStu(username).getUserid();
        Student student = studentMapper.selectByStuId(stuid);
        Integer roomid = student.getRoomid();
        Integer dormid = student.getDormid();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowDate = dateFormat.format(new Date());
        Timestamp timestamp = Timestamp.valueOf(nowDate);
        String dormname = dormitoryMapper.selectByDormId(dormid).getDormname();
        bedTime.setStuid(stuid);
        bedTime.setBedtype("0");
        bedTime.setBeddate(timestamp);
        bedTime.setStuname(student.getStuname());
        bedTime.setDormid(dormid);
        bedTime.setRoomid(roomid);
        bedTime.setDormname(dormname);
        try{
            bedTimeMapper.insertBedTime(bedTime);
            return "success";
        }catch (SqlSessionException e){
            return "failed";
        }
    }
}
