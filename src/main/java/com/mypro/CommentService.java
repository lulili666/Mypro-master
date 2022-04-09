package com.example.mypro.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mypro.enity.Comment;
import com.example.mypro.mapper.CommentMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CommentService extends ServiceImpl<CommentMapper, Comment> {
    public boolean saveUser(Comment comment) {
        return saveOrUpdate(comment);
    }
}
