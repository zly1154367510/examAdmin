package com.zly.service.impl;

import com.github.pagehelper.PageHelper;
import com.zly.dao.ScoreMapper;
import com.zly.model.Score;
import com.zly.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zly11 on 2018/5/26.
 */
@Service
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    private ScoreMapper scoreMapper;

    @Override
    public List<Score> selectAll(int page) {
        PageHelper.startPage(page,10);
        return scoreMapper.selectAll();
    }

    @Override
    public int selectNumAll() {
        return scoreMapper.selectNumAll();
    }
}
