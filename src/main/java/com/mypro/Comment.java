package com.example.mypro.enity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@TableName(value = "fun_comment")
@ApiModel(value = "Comment对象", description = "")
public class Comment implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String content;
    private Integer user_id;
    private String time;
    private Integer article_id;

    @TableField(exist = false) //标识不在comment数据库中
    private String nickname;

}