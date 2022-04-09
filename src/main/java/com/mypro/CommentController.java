package com.example.mypro.controller;


import cn.hutool.core.date.DateUtil;
//import com.example.mypro.utils.TokenUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mypro.common.Result;
import com.example.mypro.enity.Article;
import com.example.mypro.enity.Comment;
import com.example.mypro.enity.User;
import com.example.mypro.service.ArticleService;
import com.example.mypro.service.CommentService;
import com.example.mypro.service.ICommentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Resource
    private CommentService commentService;

    @Resource
    private ICommentService iCommentService;

//    @PostMapping
//    public boolean save(@RequestBody Comment comment){
//        if (comment.getId() == null){
//            comment.setTime(DateUtil.now());
////            article.setUser(TokenUtils.getCurrentUser().getNickname());
//        }
//        return commentService.saveUser(comment);
//    }
    @GetMapping
    public List<Comment > findAll(){
        return commentService.list();
    }

    @GetMapping("/{id}")
    public Result findOne(@PathVariable Integer id) {
        return Result.success(commentService.getById(id));
    }

    @GetMapping("/tree/{articleId}") //查询评论加用户信息
    public Result findTree(@PathVariable Integer articleId) {
        List<Comment> articleComments = iCommentService.findCommentDetail(articleId); //查询所有评论
        return Result.success(articleComments);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id){
        return commentService.removeById(id);
    }

    @PostMapping("/del/batch")
    public boolean deletebatch(@RequestBody List<Integer> ids){
        return commentService.removeBatchByIds(ids);
    }

}
