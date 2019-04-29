package com.qddx.service;

import com.qddx.dao.AccessMapper;
import com.qddx.dao.DormitoryMapper;
import com.qddx.dao.LogInfoMapper;
import com.qddx.dao.StudentMapper;
import com.qddx.domain.Access;
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
 * @CreateDate: 2019/4/29 10:23
 */
@Service
public class AccessServiceImp {
    @Autowired
    private AccessMapper accessMapper;
    @Autowired
    private LogInfoMapper logInfoMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private DormitoryMapper dormitoryMapper;

    public String insertInAccess(String username){
        Access access = makingAccessByUserName(username);
        access.setAcctype("进");
        try {
            accessMapper.insert(access);
            return "success";
        }catch (SqlSessionException e){
            return "failed";
        }
    }
    public String insertOutAccess(String username){
        Access access = makingAccessByUserName(username);
        access.setAcctype("出");
        try {
            accessMapper.insert(access);
            return "success";
        }catch (SqlSessionException e){
            return "failed";
        }
    }

    public Access makingAccessByUserName(String username){
        Access access = new Access();

        Integer stuid = logInfoMapper.selcetByUserNameWithStu(username).getUserid();
        Student student = studentMapper.selectByStuId(stuid);
        Integer roomid = student.getRoomid();
        Integer dormid = student.getDormid();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowDate = dateFormat.format(new Date());
        Timestamp timestamp = Timestamp.valueOf(nowDate);
        String dormname = dormitoryMapper.selectByDormId(dormid).getDormname();

        access.setStuid(stuid);
        access.setStuname(student.getStuname());
        access.setAccdate(timestamp);
        access.setDormid(dormid);
        access.setRoomid(roomid);
        access.setDormname(dormname);

        return access;
    }
}
