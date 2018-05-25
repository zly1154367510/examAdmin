package com.zly.dao;

import com.zly.model.Paper;
import org.apache.ibatis.annotations.Select;

public interface PaperMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Paper record);

    int insertSelective(Paper record);

    Paper selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Paper record);

    int updateByPrimaryKey(Paper record);

    @Select("select * from ex_paper where id=#{id}")
    Paper selectById(int id);
}