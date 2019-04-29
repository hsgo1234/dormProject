package com.qddx.dao;

import com.qddx.domain.Dormitory;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface DormitoryMapper {
    /**
    * 根据公寓id查询
    *
    * @params
    * @return
    */
    @Select("select * from dormitory where dormid = #{dormid}")
    Dormitory selectByDormId(@Param("dormid") Integer dormid);

    /**
    * 查找所有
    *
    * @params
    * @return
    */
    @Select("select * from dormitory")
    List<Dormitory> selectAll();

    /**
    * 根据公寓名字查询
    *
    * @params
    * @return
    */
    @Select("select * from dormitory where dormname = #{dormname}")
    List<Dormitory> selectByDormName(@Param("dormname") String dormname);

    /**
    * 根据公寓名称和楼号查询
    *
    * @params
    * @return
    */
    @Select("select * from dormitory where dormname = #{dormname} and dormno = #{dormno}")
    List<Dormitory> selectByDormNameAndDormNo(@Param("dormname") String dormname,@Param("dormno") String dormno);

    /**
    * 更新公寓信息
    *
    * @params
    * @return
    */
    @Update("update dormitory set dormid = #{dormid},dormname = #{dormname},dormno = #{dormno}," +
            " dormaddr = #{dormaddr}, dormcap = #{dormcap} where dormid = #{olddormid}")
    Boolean updateDormByDormId(Dormitory dormitory);

    /**
    * 插入一条公寓信息
    *
    * @params
    * @return
    */
    @Insert("insert into dormitory(dormid,dormname,dormno,dormaddr,dormcap) value " +
            "(#{dormid},#{dormname},#{dormno},#{dormaddr}, #{dormcap})")
    void insertDorm(Dormitory dormitory);

    /**
    * 删除一条公寓信息
    *
    * @params dormid
    * @return
    */
    @Delete("delete from dormitory where dormid = #{dormid}")
    void deleteByDormId(Integer dormid);

}