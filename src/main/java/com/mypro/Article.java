package com.example.mypro.enity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "fun_article")
public class Article {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private String content;
    private String user;
    private String time;
}