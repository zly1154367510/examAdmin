package com.zly.service.impl;

import com.zly.dao.SelectQuestionMapper;
import com.zly.model.SelectQuestion;
import com.zly.service.SelectQuestionService;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zly11 on 2018/5/22.
 */
@Service
public class SelectQuestionServiceImpl implements SelectQuestionService {

    @Autowired
    private SelectQuestionMapper selectQuestionMapper;

    @Override
    public List<SelectQuestion> getAll() {
        return selectQuestionMapper.selectAll();
    }
}
