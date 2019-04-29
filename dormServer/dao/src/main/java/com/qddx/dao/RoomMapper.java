package com.qddx.dao;

import com.qddx.domain.Room;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface RoomMapper {
    /**
    * 根据房间id查找
    *
    * @params
    * @return
    */
    @Select("select * from room where roomid = #{roomid}")
    Room selectByRoomid(Integer roomid);

    /**
    * 根据公寓id查找
    *
    * @params dormid
    * @return list
    */
    @Select("select * from room where dormid = #{dormid}")
    List<Room> selectByDormId(Integer dormid);

    /**
    * 根据公寓名称查找
    *
    * @params dormname
    * @return list
    */
    @Select("select * from room where dormname = #{dormname}")
    List<Room> selectByDormName(String dormname);
}