package com.qddx.dao;

import com.qddx.domain.Visitors;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface VisitorsMapper {
    /**
    * 查询所有访客记录
    *
    * @params
    * @return
    */
    @Select("select * from visitors")
    List<Visitors> selectAll();

    /**
    * 根据公寓id查询
    *
    * @params
    * @return
    */
    @Select("select * from visitors where dormid = #{dormid}")
    List<Visitors> selectByDormid(@Param("dormid") String dormid);

    /**
     * 根据公寓名称查询
     *
     * @params
     * @return
     */
    @Select("select * from visitors where dormname = #{dormname}")
    List<Visitors> selectByDormname(@Param("dormname") String dormname);

    /**
    * 插入一条访客记录
    * 
    * @params 
    * @return 
    */
    @Insert("insert into visitors (visname,vistel,state,reason,stuname,stuid,dormid,roomid) " +
            "value (#{visname},#{vistel},#{state},#{reason},#{stuname},#{stuid},#{dormid},#{roomid})")
    void insert(Visitors visitors);

}