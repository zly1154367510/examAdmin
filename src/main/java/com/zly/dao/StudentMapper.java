package com.zly.dao;

import com.zly.model.Student;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentMapper {

    @Select("select * from ex_student")
    List<Student> seletAll();

    @Select("select count(*) from ex_student")
    int seletNumAll();

}