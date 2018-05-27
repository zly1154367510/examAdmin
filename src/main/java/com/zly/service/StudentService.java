package com.zly.service;

import com.zly.model.Student;

import java.util.List;

/**
 * Created by zly11 on 2018/5/26.
 */
public interface StudentService {

    List<Student> selectAll(int page);

    int selectNumAll();

    int insertAll(String username,String name,String password);

    Student login(String username,String password);

}
