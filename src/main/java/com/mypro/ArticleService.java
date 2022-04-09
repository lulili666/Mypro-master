package com.example.mypro.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mypro.enity.Article;
import com.example.mypro.mapper.ArticleMapper;
import org.springframework.stereotype.Service;

@Service
public class ArticleService extends ServiceImpl<ArticleMapper, Article> {
    public boolean saveUser(Article article) {
        return saveOrUpdate(article);
    }

}
