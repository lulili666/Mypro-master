package com.example.mypro.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mypro.enity.Article;
import com.example.mypro.enity.Goods;
import org.apache.ibatis.annotations.Mapper;

import javax.annotation.ManagedBean;

@Mapper
public interface ArticleMapper extends BaseMapper<Article> {
}
