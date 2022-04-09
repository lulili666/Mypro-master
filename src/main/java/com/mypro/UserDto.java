package com.example.mypro.controller.dto;

import lombok.Data;

/*
* 接收前端登录的请求参数
 */
@Data
public class UserDto {
    private Integer id;
    private String username;
    private String password;
    private String nickname;
    private String building;
    private String room;
}
