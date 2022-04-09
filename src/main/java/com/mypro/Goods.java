package com.example.mypro.enity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
@TableName(value = "fun_goods")
public class Goods {
    @TableId(type = IdType.AUTO)
    private Integer gid;
    private String goodsname;
    private String describer;
    private String picture;
    private String sort;
    private String building;
    private String creater;
    private Integer num;
    private Float price;
}
