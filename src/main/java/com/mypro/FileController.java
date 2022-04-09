package com.example.mypro.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mypro.enity.Files;
import com.example.mypro.enity.Goods;
import com.example.mypro.enity.User;
import com.example.mypro.mapper.FileMapper;
import com.example.mypro.service.FileService;
import org.apache.catalina.security.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

/*
 文件上传相关接口
 */
@RestController
@RequestMapping("/file")
public class FileController {

    private String fileUploadPath = "D:/M-N/Mypro/files/";

    @Resource
    private FileMapper fileMapper;

    @Autowired
    private FileService fileService;

    @PostMapping("/upload")
    public String upload(@RequestParam MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        String type = FileUtil.extName(originalFilename);
        long size = file.getSize();
        //先存储到本地磁盘
        File uploadParentFile = new File(fileUploadPath);
        // 判断配置文件目录是否存在，若不存在新建文件目录
        if(!uploadParentFile.exists()){
            uploadParentFile.mkdirs();
        }
        //定义一个文件唯一标识码
        String uuid = IdUtil.fastSimpleUUID();
        String fileUUID = uuid + StrUtil.DOT + type;
        //实际存储路径
        File uploadFile = new File(fileUploadPath + fileUUID);

        file.transferTo(uploadFile);

        String url = "http://localhost:8081/file/" + fileUUID;
        //然后存储数据库
        Files saveFile = new Files();
        saveFile.setName(originalFilename);
        saveFile.setType(type);
        saveFile.setSize(size/1024);
        saveFile.setUrl(url);
        fileMapper.insert(saveFile);
        return url;
    }

    //下载
    @GetMapping("/{fileUUID}")
    public void download(@PathVariable String fileUUID, HttpServletResponse response) throws IOException {
        //根据唯一标识码获取文件
        File uploadFile = new File(fileUploadPath + fileUUID);
        //设置输出流格式
        ServletOutputStream os = response.getOutputStream();
        response.addHeader("Content-Disposition","attachment;filename=" + URLEncoder.encode(fileUUID,"UTF-8"));
        //读取文件字节流
        os.write(FileUtil.readBytes(uploadFile));
        os.flush();
        os.close();
    }

    @GetMapping("/show")
    public List<Files> findAll(){
        QueryWrapper<Files> wrapper = new QueryWrapper<>();// 构建一个查询的wrapper
        return fileMapper.selectList(wrapper);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id){
        return fileService.removeById(id);
    }


}
