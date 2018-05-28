package com.zly.dao;

import com.zly.model.Score;
import org.apache.ibatis.annotations.*;

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

    @Insert("insert into ex_score (id,studentid,subject,paper_id,mark) values (null,#{studengid},#{subject},#{paperId},#{mark})")
    int insertAll(@Param("studengid")String username,@Param("subject")String subject,@Param("paperId")String pId,@Param("mark")String score);
}