package com.tlias.controller;

import com.tlias.pojo.Result;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Objects;
import java.util.UUID;

import com.tlias.utils.AliOSSUtils;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@RequestMapping("/upload")
public class UploadController {
    @Resource
    private AliOSSUtils aliOSSUtils;
    /** 本地上传
     * @param image 二进制文件，这里使用图片代替
     * @return 成功
     */
    @PostMapping
    public Result upload(MultipartFile image) {
        try {
            if (!image.isEmpty()) {
                log.info("本地上传文件：{}", image.getOriginalFilename());
                // 1.获取文件名
                String originalFilename = image.getOriginalFilename();
                // 2.生成UUID 防止多人上传一样的文件，导致文件被覆盖
                String uuid = UUID.randomUUID().toString();
                String extensionName =
                    uuid + originalFilename.substring(originalFilename.lastIndexOf("."));
                // 3.存储文件, 这里有2种方式存储，一种是存储在项目根目录下，一种是上存储在classpath中
                // 3.1 存储在项目根目录下，但是好像上传后，不能马上访问，需要重启项目才能访问
                // File canonicalFile = new File("src/main/resources/static/upload/images")
                //     .getCanonicalFile();
                // String absolutePath = canonicalFile + "/" + extensionName;
                // log.info("文件上传路径：{}", absolutePath);
                // image.transferTo(new File(absolutePath));
                // // 将上传后的文件路径返给前端
                // String uploadPath = "/upload/images/" + extensionName;
                // log.info("文件上传后读取路径：{}", uploadPath);

                // 3.2 存储在classpath中，这样可以立即访问到
                String path = ResourceUtils.getURL("classpath:static/upload/images").getPath();
                String savePath = path + "/" + extensionName;
                image.transferTo(new File(savePath));
                String uploadPath = "/upload/images/" + extensionName;
                log.info("文件上传后读取路径：{}", uploadPath);
                return Result.SUCCESS(uploadPath);
            } else {
                return Result.ERROR();
            }
        } catch (IOException e) {
            log.error("文件上传失败：{}", e.getMessage());
            return Result.ERROR();
        }
    }

    /**
     * 上传头像到阿里云oss
     * @param image 图片
     * @return 成功
     */
    @PostMapping("/uploadToOSS")
    public Result uploadToOSS(MultipartFile image) throws IOException {
        String url = aliOSSUtils.upload(image);
        return Result.SUCCESS(url);
    }
}
