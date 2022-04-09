package com.example.mypro.controller;


import com.example.mypro.controller.dto.UserDto;
import com.example.mypro.enity.Goods;
import com.example.mypro.mapper.GoodsMapper;
import com.example.mypro.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired //注入其他类
    private GoodsMapper goodsMapper;

    @Autowired
    private GoodsService goodsService;


    private UserDto userDto = new UserDto();

    @PostMapping
    public boolean save(@RequestBody Goods goods){
        return goodsService.saveUser(goods);
    }

    @GetMapping("/show")
    public List<Goods> findAll(){
        return goodsService.list();
    }

    @DeleteMapping("/{gid}")
    public boolean delete(@PathVariable Integer gid){
        return goodsService.removeById(gid);
    }

    @PostMapping("/del/batch")
    public boolean deletebatch(@RequestBody List<Integer> gids){
        return goodsService.removeBatchByIds(gids);
    }

}
