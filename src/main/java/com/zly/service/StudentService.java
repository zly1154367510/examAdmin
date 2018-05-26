package com.zly.service;

import com.zly.model.Student;

import java.util.List;

/**
 * Created by zly11 on 2018/5/26.
 */
public interface StudentService {

    List<Student> selectAll(int page);

    int selectNumAll();

}
