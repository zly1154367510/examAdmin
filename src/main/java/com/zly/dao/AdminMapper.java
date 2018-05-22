package com.zly.dao;

import com.zly.model.Admin;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface AdminMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

    @Select("select * from ex_admin where username=#{username} and password=#{password}")
    Admin selectByUsernamePassword(@Param("username")String username,@Param("password")String password);
}