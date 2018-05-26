package com.zly.service.impl;

import com.github.pagehelper.PageHelper;
import com.zly.dao.StudentMapper;
import com.zly.model.Student;
import com.zly.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zly11 on 2018/5/26.
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> selectAll(int page) {
        PageHelper.startPage(page,10);
        return studentMapper.seletAll();
    }

    @Override
    public int selectNumAll() {
        return studentMapper.seletNumAll();
    }
}
