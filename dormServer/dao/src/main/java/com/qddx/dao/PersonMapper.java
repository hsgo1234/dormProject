package com.qddx.dao;

import com.qddx.domain.Person;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface PersonMapper {
    
    /**
    * 添加操作
    *
    * @params person
    * @return
    */
    @Insert("insert into person(name,age) value(#{name},#{age})")
    void insert(Person person);

    /**
    * 查询所有
    *
    * @params
    * @return 所有受影响的行
    */
    @Select("select id,name,age from person")
    List<Person> selectAll();
}
