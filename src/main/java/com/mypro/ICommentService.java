package com.example.mypro.service;

import com.example.mypro.enity.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICommentService {
    List<Comment> findCommentDetail(Integer articleId);
}
