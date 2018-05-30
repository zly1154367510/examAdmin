package com.zly.dao;

import com.zly.model.OnPerPaper;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

public interface OnPerPaperMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OnPerPaper record);

    int insertSelective(OnPerPaper record);

    OnPerPaper selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OnPerPaper record);

    int updateByPrimaryKey(OnPerPaper record);

    @Insert("insert into ex_no_per_paper (id,username,paper,item,answer,time,created) values (null,#{username},#{paper},#{item},#{answer},#{time},#{created})")
    int insertAll(
            @Param("username")String username,
            @Param("paper")int paper,
            @Param("item")int item,
            @Param("answer")String answer,
            @Param("time")String time,
            @Param("created") Date date
    );

    @Delete("delete from ex_no_per_paper where username = #{username} and paper = #{paper}")
    int deleteByUsername(@Param("username") String username,@Param("paper")int paper);

    @Select("select id,username,paper,item,time,created from ex_no_per_paper where username = #{username} Group by paper")
    @Results({
            @Result(
                    property = "papers",
                    column = "paper",
                    one = @One(select = "com.zly.dao.PaperMapper.selectById")
            )
    })
    List<OnPerPaper> selectByUsername(String username);


    @Select("select answer,item,time,paper from ex_no_per_paper where username = #{username} and paper=#{pId}")

    List<OnPerPaper> selectByUsername1(@Param("username")String username,@Param("pId")int pId);


}