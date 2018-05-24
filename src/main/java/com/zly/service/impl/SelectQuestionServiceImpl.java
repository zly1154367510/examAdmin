package com.zly.service.impl;

import com.github.pagehelper.PageHelper;
import com.zly.dao.SelectItemMapper;
import com.zly.dao.SelectQuestionMapper;
import com.zly.model.SelectQuestion;
import com.zly.service.SelectQuestionService;
import com.zly.utils.InsertId;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zly11 on 2018/5/22.
 */
@Service
public class SelectQuestionServiceImpl implements SelectQuestionService {

    @Autowired
    private SelectQuestionMapper selectQuestionMapper;

    @Autowired
    private SelectItemMapper selectItemMapper;

    @Override
    public List<SelectQuestion> getAll(int page) {
        PageHelper.startPage(page,5);
        return selectQuestionMapper.selectAll();
    }

    @Override
    public SelectQuestion selectById(Integer id) {
        return selectQuestionMapper.selectAllById(id);
    }

    @Transactional
    @Override
    public int updateQuestion(Integer qId,String subject,String type,String title,String[] trueAnswer,String[] isAnswer,String[] content,String[] itemId) {
        int res = selectQuestionMapper.updAllById(qId,subject,type,title);
        for (int i = 0;i<trueAnswer.length;i++){
            selectItemMapper.updIsAnswerById(Integer.parseInt(trueAnswer[i]),0);
        }
        for (int i = 0;i<isAnswer.length;i++){
            selectItemMapper.updIsAnswerById(Integer.parseInt(isAnswer[i]),1);
        }
        for (int i = 0;i<content.length;i++){
            selectItemMapper.updContentById(new Integer(itemId[i]),content[i]);
        }
        return res;
    }

    @Override
    public int getItemNum() {
        return selectQuestionMapper.selectNum();
    }

    @Override
    @Transactional
    public int insertQuestion(String subject, String type, String title, Integer[] isAnswer, String[] content) {
        InsertId insertId = new InsertId();
        int res = selectQuestionMapper.insertAll(subject,type,title,insertId);
        System.out.print(insertId.getId());
        for (Integer item : isAnswer){
            selectItemMapper.insertAll(insertId.getId(),1,content[item]);
            content[item] = null;
        }
        for (String item:content){
            if (item==null){
                continue;
            }
            selectItemMapper.insertAll(insertId.getId(),0,item);
        }
        return res;
    }
}
