package com.example.mypro.enity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
@TableName(value = "sys_user")
public class User {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private String username;
    private String nickname;
    @JsonIgnore
    private String password;
    private String building;
    private String room;

    //通过使用@TableField指定数据库字段别名，即此处定义可以不用与数据库一致，只需在注解中写明数据库字段名即可
}
