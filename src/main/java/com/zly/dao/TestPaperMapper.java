package com.zly.dao;

import com.zly.model.TestPaper;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface TestPaperMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TestPaper record);

    int insertSelective(TestPaper record);

    TestPaper selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TestPaper record);

    int updateByPrimaryKey(TestPaper record);

    @Select("select id,p_id as pId,q_id as qId from ex_paper_question")
    @Results({
            @Result(
                    property = "paper",
                    column = "pId",
                    one = @One(select = "com.zly.dao.PaperMapper.selectById")
            )
    })
    List<TestPaper> selectAll();

    @Select("select count(*) from ex_paper_question")
    int selectNum();
}