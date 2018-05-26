package com.zly.service;

import com.zly.model.Paper;
import com.zly.model.TestPaper;

import java.util.List;

/**
 * Created by zly11 on 2018/5/25.
 */
public interface TestPaperService {

    List<Paper> getAll(int page);

    int getNum();

    List<TestPaper> SelectAllByPId(Integer pId);

    int insertPaper(String subject,String name,Integer[] ids);
}
