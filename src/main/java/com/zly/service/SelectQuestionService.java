package com.zly.service;

import com.zly.model.SelectQuestion;

import java.util.List;

/**
 * Created by zly11 on 2018/5/22.
 */
public interface SelectQuestionService {

    List<SelectQuestion> getAll(int page);

    SelectQuestion selectById(Integer id);

    int updateQuestion(Integer qId,String subject,String type,String title,String[] trueAnswer,String[] isAnswer,String[] content,String[] itemId);

    int getItemNum();

    int insertQuestion(String subject,String type,String title,Integer[] isAnswer,String[] content);

}
