package com.example.mypro.controller;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mypro.common.Constants;
import com.example.mypro.common.Result;
import com.example.mypro.controller.dto.UserDto;
import com.example.mypro.enity.Article;
import com.example.mypro.enity.Comment;
import com.example.mypro.enity.Goods;
import com.example.mypro.enity.User;
import com.example.mypro.mapper.GoodsMapper;
import com.example.mypro.mapper.UserMapper;
import com.example.mypro.service.ArticleService;
import com.example.mypro.service.CommentService;
import com.example.mypro.service.IUserService;
import com.example.mypro.service.UserService;
import io.swagger.models.auth.In;
import org.apache.tomcat.util.bcel.classfile.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
//@Component
public class UserController {

    @Autowired //注入其他类
	private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private IUserService iUserService;

    @Autowired //注入其他类
    private GoodsMapper goodsMapper;


    @Autowired //注入其他类
    private ArticleService articleService;

    @Autowired
    private CommentService commentService;

    UserDto dto;

    @PostMapping("/login")
    public Result login(@RequestBody UserDto userDto) {
        String username = userDto.getUsername();
        String password = userDto.getPassword();
        if(StringUtils.isBlank(username) || StringUtils.isBlank(password)){
            return Result.error(Constants.CODE_400,"参数错误");
        }
        UserDto dto = iUserService.login(userDto);
        this.dto = dto;
        return Result.success(dto);
    }

    @PostMapping("/article/save") //文章保存，在此用于储存当前登录用户名
    public boolean save(@RequestBody Article article){
        if (article.getId() == null){
            article.setTime(DateUtil.now());
            article.setUser(this.dto.getNickname());
        }
        return articleService.saveUser(article);
    }

    @PostMapping("/comment/save") //文章保存，在此用于储存当前登录用户名
    public boolean save(@RequestBody Comment comment){
        if (comment.getId() == null){
            comment.setTime(DateUtil.now());
            comment.setUser_id(this.dto.getId());
        }
        return commentService.saveUser(comment);
    }

    @GetMapping("/show")
    public List<Goods> findSom() {
        QueryWrapper<Goods> wrapper = new QueryWrapper<>();// 构建一个查询的wrapper
        wrapper.eq("creater", this.dto.getUsername());// 设置条件
        return goodsMapper.selectList(wrapper);
    }

    @PostMapping
    public boolean save(@RequestBody User user){
        return userService.saveUser(user);
    }

    @GetMapping
    public List<User> findAll(){
        return userService.list();
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id){
        return userService.removeById(id);
    }

    @PostMapping("/del/batch")
    public boolean deletebatch(@RequestBody List<Integer> ids){
        return userService.removeBatchByIds(ids);
    }

    //@RequestParam接受  ?pageNum=1&pageSize=10
    //分页查询 mybatis方法
//    @GetMapping("/page")
//    public Map<String,Object> findPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize){
//       pageNum = (pageNum - 1) * pageSize;
//       Integer total = userMapper.selectTotal();
//       List<User> data = userMapper.selectPage(pageNum,pageSize);
//       Map<String,Object> res = new HashMap<>();
//       res.put("data",data);
//       res.put("total",total);
//       return res;
//    }

    //分页查询 mybatis-plus方法
    @GetMapping("/page")
    public IPage<User> findPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize,
                                @RequestParam(defaultValue = "") String username,
                                @RequestParam(defaultValue = "") String nickname){
        IPage<User> page = new Page<>(pageNum,pageSize);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if(!"".equals(username)) queryWrapper.like("username",username);
        if(!"".equals(nickname)) queryWrapper.like("nickname",nickname);
        queryWrapper.orderByDesc("id");
        IPage<User> userPage = userService.page(page,queryWrapper);
        return userPage;
    }
}
