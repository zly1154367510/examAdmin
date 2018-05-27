package com.zly.dao;

import com.zly.model.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentMapper {

    @Select("select * from ex_student")
    List<Student> seletAll();

    @Select("select count(*) from ex_student")
    int seletNumAll();

    @Insert("insert into ex_student (id,username,name,password) values (null,#{username},#{name},#{password})")
    int insertAll(@Param("username")String username,@Param("name")String name,@Param("password")String password);

    @Select("select * from ex_student where username=#{username} and  password=#{password}")
    Student seletByUsernamePassowrd(@Param("username")String username,@Param("password")String password);

}