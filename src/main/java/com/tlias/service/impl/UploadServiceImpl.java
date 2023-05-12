package com.tlias.service.impl;

import com.tlias.service.UploadService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadServiceImpl implements UploadService {
    /**
     * 图片上传到本地服务器
     * @param image 图片文件流
     * @return url
     */
    @Override
    public String uploadImageToLocal(MultipartFile image) {

        return "";
    }
}
