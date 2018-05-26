package com.zly.dao;

import com.zly.model.SelectQuestion;
import com.zly.utils.InsertId;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface SelectQuestionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SelectQuestion record);

    int insertSelective(SelectQuestion record);

    SelectQuestion selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SelectQuestion record);

    int updateByPrimaryKeyWithBLOBs(SelectQuestion record);

    int updateByPrimaryKey(SelectQuestion record);

    @Select("select id,subject,type,title,memo from ex_select_question")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(
                    property = "itemList",
                    column = "id",
                    many = @Many(select = "com.zly.dao.SelectItemMapper.selectByQuestionId")
            )
    })
    List<SelectQuestion> selectAll();

    @Select("select id,subject,type,title,memo from ex_select_question where id=#{id}")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(
                    property = "itemList",
                    column = "id",
                    many = @Many(select = "com.zly.dao.SelectItemMapper.selectByQuestionId")
            )
    })
    SelectQuestion selectAllById(int id);

    @Select("select id,subject,type,title,memo from ex_select_question where subject = #{subject}")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(
                    property = "itemList",
                    column = "id",
                    many = @Many(select = "com.zly.dao.SelectItemMapper.selectByQuestionId")
            )
    })
    List<SelectQuestion> selectAllBySubject(String subject);

    Integer selectNumBySubject(String subject);

    @Update("update ex_select_question set subject=#{subject},type=#{type},title=#{title} where id=#{id}")
    int updAllById(@Param("id")Integer id,@Param("subject")String subject,@Param("type")String type,@Param("title")String title);

    @Select("select count(*) from ex_select_question")
    int selectNum();

    @Insert("insert into ex_select_question(id,subject,type,title) values (null,#{subject},#{type},#{title})")
    @Options(useGeneratedKeys = true, keyProperty = "InsertId.id")
    int insertAll(@Param("subject")String subject,@Param("type")String type,@Param("title")String title,@Param("InsertId")InsertId id);
}