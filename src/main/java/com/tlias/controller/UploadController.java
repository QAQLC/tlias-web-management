package com.tlias.controller;

import com.tlias.pojo.Result;
import com.tlias.service.UploadService;
import com.tlias.utils.AliOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;


@Slf4j
@RestController
@RequestMapping("/upload")
public class UploadController {
    @Autowired
    private AliOSSUtils aliOSSUtils;
    @Autowired
    private UploadService uploadService;
    /**
     * 员工上传图片, 文件储存在服务器
     * 需要校验上传的图片是否是必填 非null
     * @param image 图片二进制流
     * @return Result
     */
    @PostMapping("/uploadImageToLocal")
    public Result uploadImageToLocal (Integer id, MultipartFile image) {
        log.info("图片上传：{}", image.getOriginalFilename());
        String url = uploadService.uploadImageToLocal(image);
        return Result.SUCCESS(url);
    }

    /**
     * 图片上传到阿里云OSS
     * @param file 图片文件流
     * @return Result
     */
    @PostMapping("/uploadImage")
    public Result uploadImageToOss (MultipartFile file) throws IOException {
        log.info("文件上传：{}", file.getOriginalFilename());
        String url = aliOSSUtils.upload(file);
        return Result.SUCCESS(url);
    }
}
