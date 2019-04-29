package com.qddx.controller;

import com.qddx.dao.*;
import com.qddx.domain.*;
import com.qddx.service.AccessServiceImp;
import com.qddx.service.HelloSender;
import com.qddx.service.MailServiceImpl;
import org.apache.ibatis.session.SqlSessionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RestController
public class ControllerApplication {
    @Autowired
    private PersonMapper personMapper;
    @Autowired
    private HelloSender helloSender;
    @Autowired
    private MailServiceImpl mailService;
    @Autowired
    private AccessServiceImp accessServiceImp;
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private LogInfoMapper logInfoMapper;
    @Autowired
    private DormitoryMapper dormitoryMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private VisitorsMapper visitorsMapper;
    @Autowired
    private AccessMapper accessMapper;
    @Autowired
    private BedTimeMapper bedTimeMapper;
    @Autowired
    private RoomMapper roomMapper;

    /**
    * 公寓
    *
    * @params
    * @return
    */
    @RequestMapping("/selectDormByDormName")
    public List<Dormitory> selectByDormName(String dormname){
        return dormitoryMapper.selectByDormName(dormname);
    }
    @RequestMapping("/dormSelectAll")
    public List<Dormitory> dormSelectAll(){
        return dormitoryMapper.selectAll();
    }
    @RequestMapping("/updateDorm")
    public String updateDormByDormId(@RequestBody Dormitory dormitory){
        try {
            dormitoryMapper.updateDormByDormId(dormitory);
            return "success";
        }catch (SqlSessionException e){
            return e.toString();
        }
    }
    @RequestMapping("/insertDorm")
    public String insertDorm(@RequestBody Dormitory dormitory){
        try {
            dormitoryMapper.insertDorm(dormitory);
            return "success";
        }catch (SqlSessionException e){
            return e.toString();
        }
    }
    @RequestMapping("/deleteByDormId")
    public void deleteByDormId(Integer dormid){
        try {
            dormitoryMapper.deleteByDormId(dormid);
        }catch (SqlSessionException e){
        }
    }

    /**
    * 学生
    *
    * @params
    * @return
    */
    @RequestMapping("/selectStuByStuEYear")
    public List<Student> selectStuByStuEYear(Integer stueyear){
        return studentMapper.selectByStuEYear(stueyear);
    }
    @RequestMapping("/selectStuByDormName")
    public List<Student> selectStuByDormName(String dormname){
        List<Student> students = new ArrayList<>();
        dormitoryMapper.selectByDormName(dormname).forEach(data ->{
            students.addAll(studentMapper.selectByDormId(data.getDormid()));
        });
        return students;
    }
    @RequestMapping("/updateStu")
    public String updateStu(@RequestBody Student student){
        try{
            studentMapper.updateStuByStuId(student);
            return "updateStu success";
        }catch (SqlSessionException e){
            return "updateStu falid";
        }
    }
    @RequestMapping("/insertStu")
    public void insertStu(@RequestBody Student student){
        try {
            studentMapper.insertStu(student);
        }catch (SqlSessionException e){

        }
    }
    @RequestMapping("/deleteByStuId")
    public void deleteByStuId(Integer stuid){
        try {
            studentMapper.deleteByStuId(stuid);
        }catch (SqlSessionException e){
        }
    }

    /**
    * 登录信息
    *
    * @params
    * @return
    */
    @RequestMapping("selectLoginInfoByUsertype")
    public List<LogInfo> selectLoginInfoByUsertype(String usertype){
        return logInfoMapper.selectByUserType(usertype);
    }
    @RequestMapping("updateLoginInfo")
    public void updateLoginInfo(@RequestBody LogInfo logInfo){
        logInfoMapper.UpdateByUserId(logInfo);
    }
    @RequestMapping("insertLoginInfo")
    public void insertLoginInfo(@RequestBody LogInfo logInfo){
        logInfoMapper.insertLoginInfo(logInfo);
    }
    @RequestMapping("/login")
    public String login(@RequestBody LogInfo logInfo){
        String username = logInfo.getUsername();
        String password = logInfo.getPassword();
        LogInfo logInfo1 =logInfoMapper.selcetByUserNameWithAdmin(username);
        if (logInfo1==null){
            System.out.println("用户名不存在");
            return "用户名不存在";
        }else {
            if (logInfo1.getPassword().equals(password)){
                System.out.println("success");
                return "success";
            }else {
                System.out.println("密码错误");
                return "密码错误";
            }
        }
    }
    @RequestMapping("/loginStu")
    public String loginStu(@RequestBody LogInfo logInfo){
        String username = logInfo.getUsername();
        String password = logInfo.getPassword();
        LogInfo logInfo1 =logInfoMapper.selcetByUserNameWithStu(username);
        if (logInfo1==null){
            System.out.println("用户名不存在");
            return "用户名不存在";
        }else {
            if (logInfo1.getPassword().equals(password)){
                System.out.println("success");
                return "success";
            }else {
                System.out.println("密码错误");
                return "密码错误";
            }
        }
    }

    /**
    * 访客
    *
    * @params
    * @return
    */
    @RequestMapping("/selectVisitors")
    public List<Visitors> selectVisitorsByDormName(String dormname){
        return visitorsMapper.selectByDormname(dormname);
    }

    /**
    * 门禁
    *
    * @params
    * @return
    */
    @RequestMapping("/selectAccess")
    public List<Access> selectAccess(){
        return accessMapper.selectAll();
    }
    @RequestMapping("/insertInAccess")
    public String insertInAccess(String username){
        return accessServiceImp.insertInAccess(username);
    }
    @RequestMapping("/insertOutAccess")
    public String insertOutAccess(String username){
        return accessServiceImp.insertOutAccess(username);
    }

    /**
    * 归寝记录
    *
    * @params
    * @return
    */
    @RequestMapping("/selectBedByDormName")
    public List<BedTime> selectBedByDormName(String dormname){
        return bedTimeMapper.selectByDormName(dormname);
    }

    @RequestMapping("insertBedTime")
    public String insertBetTime(String username){
        try{
            helloSender.send(username);
            return "success";
        }catch (Exception e){
            return "failed";
        }
    }
    /**
     *邮件
     *
     * @params
     * @return
     */
    @RequestMapping("/sendmail")
    public String sendMail(@RequestBody Email email) throws Exception{
        try{
            mailService.sendSimpleMail(email);
            return "success";
        }catch(Exception e) {
            return "failed";
        }
    }

    /**
    * 测试
    *
    * @params
    * @return
    */
    @RequestMapping("/insert")
    public Integer save(){
        Person person = new Person();
        person.setName("小花");
        person.setAge(15);
        personMapper.insert(person);
        return person.getId();
    }

    @RequestMapping("/selectAll")
    public List<Person> selectAll(){
        return personMapper.selectAll();
    }

    @RequestMapping(value = "/userAll")
    public UserInfo login(){
        return userInfoMapper.findByUsername("admin");
    }

    @RequestMapping(value = "test")
    public Person  test(@RequestBody Person person){
        System.out.println(person.toString());
        return person;
    }
}