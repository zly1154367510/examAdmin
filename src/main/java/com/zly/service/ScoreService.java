package com.zly.service;

import com.zly.model.Score;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by zly11 on 2018/5/26.
 */
public interface ScoreService {

    List<Score> selectAll(int page);

    int selectNumAll();

    boolean evaluationScore(Integer questionId, String[] itemId);

    int insertAll(String username,String subject,String pId,String score);

    List<Score> selectBySId(String id);
}
