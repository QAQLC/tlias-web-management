package com.tlias.service;

import org.springframework.web.multipart.MultipartFile;

public interface UploadService {
    String uploadImageToLocal(MultipartFile image);
}
