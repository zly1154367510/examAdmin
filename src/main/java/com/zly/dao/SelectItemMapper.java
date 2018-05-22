package com.zly.dao;

import com.zly.model.SelectItem;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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
}