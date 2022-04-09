package com.example.mypro.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mypro.enity.Files;
import com.example.mypro.enity.User;
import com.example.mypro.mapper.FileMapper;
import com.example.mypro.mapper.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class FileService extends ServiceImpl<FileMapper, Files> {
}
