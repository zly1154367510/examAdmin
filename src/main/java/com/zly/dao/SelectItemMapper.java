package com.zly.dao;

import com.zly.model.SelectItem;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface SelectItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SelectItem record);

    int insertSelective(SelectItem record);

    SelectItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SelectItem record);

    int updateByPrimaryKey(SelectItem record);

    @Select("select * from ex_select_item where select_question_id =#{questionId}")
    List<SelectItem> selectByQuestionId(@Param("questionId")int id);

    @Update("update ex_select_item set content=#{content} where id=#{id}")
    int updContentById(@Param("id") Integer id,@Param("content") String content);

    @Update("update ex_select_item set isanswer=#{isanswer} where id=#{id}")
    int updIsAnswerById(@Param("id") Integer id,@Param("isanswer") int isanswer);

    @Insert("insert into ex_select_item(id,select_question_id,isanswer,content) values (null,#{select_question_id},#{isanswer},#{content})")
    int insertAll(@Param("select_question_id")Integer selectQuestionId,@Param("isanswer")Integer isanswer,@Param("content") String content);
}