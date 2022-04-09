package com.example.mypro.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mypro.common.Constants;
import com.example.mypro.controller.dto.UserDto;
import com.example.mypro.enity.User;
import com.example.mypro.exception.ServiceException;
import com.example.mypro.mapper.UserMapper;
import com.example.mypro.service.IUserService;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public UserDto login(UserDto userDto) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", userDto.getUsername());
        queryWrapper.eq("password", userDto.getPassword());
        User one;
        try {
            one = getOne(queryWrapper); //数据库查询用户信息
        } catch (Exception e) {
            throw new ServiceException(Constants.CODE_500,"系统错误");
        }
        if (one != null) {
            BeanUtils.copyProperties(one, userDto, String.valueOf(true));
            return userDto;
        } else
        {
            throw new ServiceException(Constants.CODE_600,"用户名或密码错误");
        }

    }
}
