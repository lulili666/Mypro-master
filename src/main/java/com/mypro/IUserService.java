package com.example.mypro.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mypro.controller.dto.UserDto;
import com.example.mypro.enity.User;
import org.springframework.stereotype.Service;

/*
服务类
 */
@Service
public interface IUserService extends IService<User> {
    UserDto login(UserDto userDto);
}
