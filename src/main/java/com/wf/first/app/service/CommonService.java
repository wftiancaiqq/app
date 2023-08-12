package com.wf.first.app.service;

import org.springframework.web.multipart.MultipartFile;

public interface CommonService {
    String upload(MultipartFile file);
}
