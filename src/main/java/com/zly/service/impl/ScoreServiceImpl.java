package com.zly.service.impl;

import com.github.pagehelper.PageHelper;
import com.zly.dao.ScoreMapper;
import com.zly.dao.SelectItemMapper;
import com.zly.model.Score;
import com.zly.model.SelectItem;
import com.zly.model.TestPaper;
import com.zly.service.ScoreService;
import com.zly.service.TestPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by zly11 on 2018/5/26.
 */
@Service
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    private ScoreMapper scoreMapper;

    @Autowired
    private TestPaperService testPaperService;

    @Autowired
    private SelectItemMapper selectItemMapper;

    @Override
    public List<Score> selectAll(int page) {
        PageHelper.startPage(page,10);
        return scoreMapper.selectAll();
    }

    @Override
    public int selectNumAll() {
        return scoreMapper.selectNumAll();
    }

    @Override
    public boolean evaluationScore(Integer questionId,String[] itemId) {
        boolean flag = false;
        int len = selectItemMapper.selectByQuestionIdIsanswer(questionId);
        if (len != itemId.length){
            return flag;
        }
        for (String i:itemId){
            SelectItem selectItem = selectItemMapper.selectById(Integer.parseInt(i));
            if (!selectItem.getIsanswer()){
                flag = false;
                break;
            }
            flag = true;
        }
        return flag;
    }

    @Override
    public int insertAll(String username, String subject, String pId, String score) {
        return scoreMapper.insertAll(username, subject, pId, score);
    }
}
