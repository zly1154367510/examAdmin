package com.zly.service.impl;

import com.github.pagehelper.PageHelper;
import com.zly.dao.TestPaperMapper;
import com.zly.model.TestPaper;
import com.zly.service.TestPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zly11 on 2018/5/25.
 */
@Service
public class TestPaperSerivceImpl implements TestPaperService {

    @Autowired
    private TestPaperMapper testPaperMapper;

    @Override
    public List<TestPaper> getAll(int page) {
        PageHelper.startPage(page,10);
        return testPaperMapper.selectAll();
    }

    @Override
    public int getNum() {
        return testPaperMapper.selectNum();
    }
}
