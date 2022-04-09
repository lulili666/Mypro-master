package com.example.mypro.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mypro.controller.dto.GoodsDto;
import com.example.mypro.enity.Goods;
import com.example.mypro.mapper.GoodsMapper;
import org.springframework.stereotype.Service;

@Service
public class GoodsService extends ServiceImpl<GoodsMapper,Goods> {
    public boolean saveUser(Goods goods) {
        return saveOrUpdate(goods);
    }

}
