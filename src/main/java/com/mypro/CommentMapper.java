package com.example.mypro.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mypro.enity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import javax.annotation.ManagedBean;
import java.util.List;

@Mapper
public interface CommentMapper extends BaseMapper<Comment> {

    @Select("select c.*,u.nickname from fun_comment c left join sys_user u on c.user_id = u.id "+
            "where c.article_id = #{articleId} order by id desc")
    List<Comment> findCommentDetail(@Param("articleId") Integer articleId);
}
