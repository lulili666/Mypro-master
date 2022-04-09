package com.example.mypro.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mypro.enity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {

//        @Select("SELECT * from sys_user")
//        List<User> findAll();
//
//        @Insert("INSERT into sys_user(username,nickname,password,email,phone,address) VALUES (#{username},"+
//                "#{nickname},#{password},#{email},#{phone},#{address})")
//        int insert(User user);
//
//        int update(User user);
//
//        @Delete("delete from sys_user where id = #{id}")
//        Integer deleteById(@Param("id") Integer id);
//
//        @Select("select * from sys_user limit #{pageNum}, #{pageSize}")
//        List<User> selectPage(Integer pageNum, Integer pageSize);
//
//        @Select("select count(*) from sys_user")
//        Integer selectTotal();
}
