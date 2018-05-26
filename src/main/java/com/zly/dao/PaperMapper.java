package com.zly.dao;

import com.zly.model.Paper;
import com.zly.utils.InsertId;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

public interface PaperMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Paper record);

    int insertSelective(Paper record);

    Paper selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Paper record);

    int updateByPrimaryKey(Paper record);

    @Select("select * from ex_paper where id=#{id}")
    Paper selectById(int id);

    @Select("select * from ex_paper")
    List<Paper> selectAll();

    @Select("select count(*) from ex_paper")
    int selectAllNum();

    @Options(useGeneratedKeys = true, keyProperty = "InsertId.id")
    @Insert("insert into ex_paper (id,created,subject,name) values (null,#{created},#{subject},#{name})")
    int InsertAll(@Param("created")Date created,@Param("subject")String subject,@Param("name")String name,@Param("InsertId")InsertId id);
}