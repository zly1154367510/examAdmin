package com.zly.service.impl;

import com.github.pagehelper.PageHelper;
import com.zly.dao.OnPerPaperMapper;
import com.zly.dao.PaperMapper;
import com.zly.dao.TestPaperMapper;
import com.zly.model.OnPerPaper;
import com.zly.model.Paper;
import com.zly.model.TestPaper;
import com.zly.service.TestPaperService;
import com.zly.utils.InsertId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by zly11 on 2018/5/25.
 */
@Service
public class TestPaperSerivceImpl implements TestPaperService {

    @Autowired
    private TestPaperMapper testPaperMapper;

    @Autowired
    private PaperMapper paperMapper;

    @Autowired
    private OnPerPaperMapper noPerPaperMapper;

    @Override
    public List<Paper> getAll(int page) {
        PageHelper.startPage(page,10);
        return paperMapper.selectAll();
    }

    @Override
    public int getNum() {
        return paperMapper.selectAllNum();
    }

    @Override
    public List<TestPaper> SelectAllByPId(Integer pId) {
        return testPaperMapper.selectAllByPId(pId);
    }

    @Transactional
    @Override
    public int insertPaper(String subject, String name,Integer[] ids,String time) {
        InsertId id = new InsertId();
        int i = paperMapper.InsertAll(new Date(System.currentTimeMillis()),subject,name,id,time);
        for (int item : ids){
            testPaperMapper.insertAll(id.getId(),item);
        }
        return i;
    }

    @Override
    public Paper selecPaperById(int id) {
        return paperMapper.selectById(id);
    }

    @Override
    public String selTimeById(int id) {
        return paperMapper.selectTimeById(id);
    }

    @Override
    public int savePaper(String username,int paper,int item,String answer,String time, Date date) {
        return noPerPaperMapper.insertAll(username, paper, item, answer, time,date);
    }

    @Override
    public int delByUsernamePaper(String username, int paper) {
        return noPerPaperMapper.deleteByUsername(username,paper);
    }

    @Override
    public List<OnPerPaper> selectNoPerByUsername(String username) {
        return noPerPaperMapper.selectByUsername(username);
    }

    @Override
    public List<OnPerPaper> selectNoPerByUsername1(String username,int pId) {
        return noPerPaperMapper.selectByUsername1(username,pId);
    }
}
