package com.zly.service;

import com.zly.model.Score;

import java.util.List;

/**
 * Created by zly11 on 2018/5/26.
 */
public interface ScoreService {

    List<Score> selectAll(int page);

    int selectNumAll();
}
