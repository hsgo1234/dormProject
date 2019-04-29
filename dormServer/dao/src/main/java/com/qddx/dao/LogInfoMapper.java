package com.qddx.dao;

import com.qddx.domain.LogInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface LogInfoMapper {

    /**
    * 根据admin的username查询
    * 
    * @params 
    * @return 
    */
    @Select("select * from loginfo where username = #{username} and usertype = 'admin'")
    LogInfo selcetByUserNameWithAdmin(@Param("username") String username);

    /**
     * 根据admin的username查询
     *
     * @params
     * @return
     */
    @Select("select * from loginfo where username = #{username} and usertype = 'student'")
    LogInfo selcetByUserNameWithStu(@Param("username") String username);

    /**
    * 根据身份类型查询
    *
    * @params
    * @return
    */
    @Select("select * from loginfo where usertype = #{usertype}")
    List<LogInfo> selectByUserType(String usertype);

    /**
    * 根据用户id和用户类型查询
    * 
    * @params 
    * @return 
    */
    @Select("select * from loginfo where usertype = #{usertype} and userid = #{userid}")
    LogInfo selceByUserTypeAndUserId(@Param("usertype") String usertype,@Param("userid") Integer userid);

    /**
    * 根据用户id更新数据
    * 
    * @params 
    * @return 
    */
    @Update("update loginfo set usertype = #{usertype}, userid = #{userid}, username = #{username}, " +
            "password = #{password} where userid = #{userid}")
    void UpdateByUserId(LogInfo logInfo);
    
    /**
    * 插入一条数据
    * 
    * @params 
    * @return 
    */
    @Insert("insert into loginfo(usertype, userid, username, password) value(#{usertype}, #{userid}, #{username}," +
            " #{password})")
    void insertLoginInfo(LogInfo logInfo);
}