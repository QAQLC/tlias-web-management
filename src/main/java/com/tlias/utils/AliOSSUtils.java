package com.tlias.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.tlias.pojo.AliOSSProperties;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * 上传到OSS
 */
@Data
@Component
public class AliOSSUtils {
    @Autowired
    private AliOSSProperties aliOSSProperties;
    /**
     * 实现上传图片到oss
     * @param file 上传文件流
     * @return 上传文件存储oss地址
     */
    public String upload (MultipartFile file) throws Exception {
        String endpoint = aliOSSProperties.getEndpoint();
        String accessKeyId = aliOSSProperties.getAccessKeyId();
        String accessKeySecret = aliOSSProperties.getAccessKeySecret();
        String bucketName = aliOSSProperties.getBucketName();

        // 获取上传的文件输入流
        InputStream inputStream = file.getInputStream();
        // 避免文件覆盖，使用uuid
        String originalFilename = file.getOriginalFilename();
        // 判断文件类型
        String contentType = file.getContentType();
        String objectName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
        if (contentType.endsWith("jpeg") || contentType.endsWith("png") || contentType.endsWith("jpg")) {
            objectName = "images/" + objectName;
        }

        // 上传文件到OSS
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        ossClient.putObject(bucketName, objectName, inputStream);
        ossClient.shutdown();
        // 返回文件访问路径给前端展示
        return endpoint.split("//")[0] + "//" + bucketName + "." + endpoint.split("//")[1] + "/" + objectName;
    }
}
