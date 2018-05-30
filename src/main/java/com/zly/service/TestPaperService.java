package com.zly.service;

import com.zly.model.OnPerPaper;
import com.zly.model.Paper;
import com.zly.model.TestPaper;

import java.util.Date;
import java.util.List;

/**
 * Created by zly11 on 2018/5/25.
 */
public interface TestPaperService {

    List<Paper> getAll(int page);

    int getNum();

    List<TestPaper> SelectAllByPId(Integer pId);

    int insertPaper(String subject,String name,Integer[] ids,String time);

    Paper selecPaperById(int id);

    String selTimeById(int id);

    int savePaper(String username,int paper,int item,String answer,String time, Date date);

    int delByUsernamePaper(String username,int paper);

    List<OnPerPaper> selectNoPerByUsername(String username);

    List<OnPerPaper> selectNoPerByUsername1(String username,int pId);
}
