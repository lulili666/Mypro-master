package com.example.mypro.controller;


import cn.hutool.core.date.DateUtil;
//import com.example.mypro.utils.TokenUtils;
import com.example.mypro.common.Result;
import com.example.mypro.enity.Article;
import com.example.mypro.enity.User;
import com.example.mypro.service.ArticleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Resource
    private ArticleService articleService;

//    @PostMapping
//    public boolean save(@RequestBody Article article){
//        if (article.getId() == null){
//            article.setTime(DateUtil.now());
////            article.setUser(TokenUtils.getCurrentUser().getNickname());
//        }
//        return articleService.saveUser(article);
//    }
    @GetMapping
    public List<Article> findAll(){
        return articleService.list();
    }

    @GetMapping("/{id}")
    public Result findOne(@PathVariable Integer id) {
        return Result.success(articleService.getById(id));
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id){
        return articleService.removeById(id);
    }

    @PostMapping("/del/batch")
    public boolean deletebatch(@RequestBody List<Integer> ids){
        return articleService.removeBatchByIds(ids);
    }

}
