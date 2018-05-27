package com.zly.service.impl;

import com.github.pagehelper.PageHelper;
import com.zly.dao.StudentMapper;
import com.zly.model.Student;
import com.zly.service.RedisService;
import com.zly.service.StudentService;
import com.zly.utils.Md5Utils;
import com.zly.utils.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zly11 on 2018/5/26.
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private RedisService redisService;

    @Override
    public List<Student> selectAll(int page) {
        PageHelper.startPage(page,10);
        return studentMapper.seletAll();
    }

    @Override
    public int selectNumAll() {
        return studentMapper.seletNumAll();
    }

    @Override
    public int insertAll(String username, String name, String password) {
        password = Md5Utils.MD5(password);
        return studentMapper.insertAll(username, name, password);
    }

    /**
     *
     * @param username
     * @param password
     * @return 生成的token
     */
    @Override
    public Student login(String username, String password) {
        password = Md5Utils.MD5(password);
        Student student = studentMapper.seletByUsernamePassowrd(username, password);
        String token = null;
        if (student != null){
            token = UUIDUtil.getUUID();
            redisService.create(username, token);
            student.setToken(token);
        }
        return student;
    }
}
