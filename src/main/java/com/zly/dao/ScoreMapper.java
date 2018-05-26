package com.zly.dao;

import com.zly.model.Score;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ScoreMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Score record);

    int insertSelective(Score record);

    Score selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Score record);

    int updateByPrimaryKey(Score record);

    @Select("select id,studentid,subject,paper_id as paperId,mark from ex_score")
    @Results({
            @Result(
                    property = "paper",
                    column = "paperId",
                    one = @One(select = "com.zly.dao.PaperMapper.selectById")
            )
    })
    List<Score> selectAll();

    @Select("select count(*) from ex_score")
    int selectNumAll();
}