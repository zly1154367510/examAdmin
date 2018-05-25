package com.zly.service;

import com.zly.model.TestPaper;

import java.util.List;

/**
 * Created by zly11 on 2018/5/25.
 */
public interface TestPaperService {

    List<TestPaper> getAll(int page);

    int getNum();
}
