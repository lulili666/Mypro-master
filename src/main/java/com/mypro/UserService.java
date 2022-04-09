package com.example.mypro.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mypro.controller.dto.UserDto;
import com.example.mypro.enity.User;
import com.example.mypro.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends ServiceImpl<UserMapper,User> {
    public boolean saveUser(User user) {
//        if(user.getId() == null){
//            return save(user);  //mybatis-plus提供,表示插入数据
//        } else{
//            return updateById(user);
//        }
        return saveOrUpdate(user);
    }


//
//    @Autowired
//    private UserMapper userMapper;
//
//    public int save(User user) {
//        if(user.getId()==null)
//            return userMapper.insert(user);
//        else
//            return userMapper.update(user);
//    }
}
