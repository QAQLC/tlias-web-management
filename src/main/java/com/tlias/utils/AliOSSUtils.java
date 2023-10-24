package com.tlias.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import jakarta.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 * 阿里云OSS工具类
 */
@Component
public class AliOSSUtils {

    @Resource
    private AliOSSProperties aliOSSProperties;

    public String upload(MultipartFile image) throws IOException {
        if (image.isEmpty()) {
            throw new RuntimeException("上传文件不能为空");
        }
        String endpoint = aliOSSProperties.getEndpoint();
        String bucketName = aliOSSProperties.getBucketName();
        String accessKeyId = aliOSSProperties.getAccessKeyId();
        String accessKeySecret = aliOSSProperties.getAccessKeySecret();

        // 1.获取文件名
        String originalFilename = image.getOriginalFilename();
        // 2.生成UUID 防止多人上传一样的文件，导致文件被覆盖
        String uuid = UUID.randomUUID().toString();
        String extensionName = uuid + originalFilename.substring(originalFilename.lastIndexOf("."));
        // 3.获取文件流
        InputStream inputStream = image.getInputStream();
        // 4.创建OSSClient实例
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        // 5.上传文件流
        ossClient.putObject(bucketName, extensionName, inputStream);
        // 6.关闭OSSClient
        ossClient.shutdown();
        // 7.返回文件路径
        return (
            endpoint.split("//")[0] +
            "//" +
            bucketName +
            "." +
            endpoint.split("//")[1] +
            "/" +
            extensionName
        );
    }
}
