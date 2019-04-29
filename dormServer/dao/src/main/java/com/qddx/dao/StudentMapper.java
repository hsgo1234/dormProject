package com.qddx.dao;

import com.qddx.domain.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface StudentMapper {
    /**
     * 查找所有学生
     *
     * @params stuid
     * @return student
     */
    @Select("select * from student")
    List<Student> selectAll();

    /**
    * 根据学生id查找
    * 
    * @params stuid
    * @return student
    */
    @Select("select * from student where stuid = #{stuid}")
    Student selectByStuId(Integer stuid);
    
    /**
    * 根据学生姓名查找
    * 
    * @params 
    * @return 
    */
    @Select("select * from student where stuname = #{stuname}")
    List<Student> selectByStuName(@Param("stuname") String stuname);
    
    /**
    * 根据房间id查询
    * 
    * @params 
    * @return 
    */
    @Select("select * from student where roomid = #{roomid}")
    List<Student> selectByRoomId(Integer roomid);

    /**
     * 根据公寓名称查找
     *
     * @params stuid
     * @return student
     */
    @Select("select * from student where dormname = #{dormname}")
    List<Student> selectByDormName(String dormname);

    /**
    * 根据入学年份查询
    * 
    * @params 
    * @return 
    */
    @Select("select * from student where stueyear = #{stueyear}")
    List<Student> selectByStuEYear(Integer stueyear);
     
    /**
    * 根据公寓id查询
    * 
    * @params 
    * @return 
    */
    @Select("select * from student where dormid = #{dormid}")
    List<Student> selectByDormId(Integer dormid);

    @Update("update student set stuid = #{stuid}, stueyear = #{stueyear}, roomid = #{roomid}, dormid=#{dormid}," +
            " stuname = #{stuname}, stutel = #{stutel}, stumail = #{stumail}, studep=#{studep} where stuid=#{stuid}")
    Boolean updateStuByStuId(Student student);

    @Insert("insert into student(stuid, stueyear, roomid, dormid, stuname, stutel, stumail, stusex, stuins, studep, stuclass) " +
            "value(#{stuid}, #{stueyear}, #{roomid}, #{dormid}, #{stuname}, #{stutel}, #{stumail}, #{stusex}, #{stuins}, #{studep}, #{stuclass})")
    void insertStu(Student student);
    /**
     * 删除一条学生信息
     *
     * @params dormid
     * @return
     */
    @Delete("delete from student where stuid = #{stuid}")
    void deleteByStuId(Integer stuid);
}