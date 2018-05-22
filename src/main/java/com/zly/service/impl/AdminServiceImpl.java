package com.zly.service.impl;

import com.zly.dao.AdminMapper;
import com.zly.model.Admin;
import com.zly.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zly11 on 2018/5/22.
 */
@Service

public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin login(String username, String password) {
        return adminMapper.selectByUsernamePassword(username,password);
    }
}
