package com.qddx.dao;

import com.qddx.domain.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface TeacherMapper {
    /**
    * 根据教师名字查询
    * 
    * @params 
    * @return 
    */
    @Select("select * from teacher where teaname = #{teaname}")
    List<Teacher> selectByTeaName(@Param("teaname") String teaname);
    
    /**
    * 根据教师id查询
    * 
    * @params
    * @return 
    */
    @Select("select * from teacher where teaid = #{teaid}")
    Teacher selectByTeaId(Integer teaid);
}