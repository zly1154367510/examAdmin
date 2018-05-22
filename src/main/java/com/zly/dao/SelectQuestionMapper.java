package com.zly.dao;

import com.zly.model.SelectQuestion;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SelectQuestionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SelectQuestion record);

    int insertSelective(SelectQuestion record);

    SelectQuestion selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SelectQuestion record);

    int updateByPrimaryKeyWithBLOBs(SelectQuestion record);

    int updateByPrimaryKey(SelectQuestion record);

    @Select("select * from ex_select_question")
    @Results({
            @Result(
                    property = "itemList",
                    column = "id",
                    many = @Many(select = "com.zly.dao.SelectItemMapper.selectByQuestionId")
            )
    })
    List<SelectQuestion> selectAll();
}