package com.wf.first.app.service.impl;

import com.wf.first.app.service.CommonService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

@Service
public class CommonServiceImpl implements CommonService {
    private final static String FILE_HOST = "http://192.168.31.206:80";
    @Override
    public String upload(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        String extension = fileName.substring(fileName.lastIndexOf("."));
        UUID uuid = UUID.randomUUID();
        String newFileName = uuid.toString() + extension;
        String url = FILE_HOST + "/avatar/" + newFileName;
        File storeFile = new File("E:/nginx-1.24.0/images/avatar/" + newFileName);
        FileOutputStream fos =null;
        try {
            fos = new FileOutputStream(storeFile);
            fos.write(file.getBytes());
            fos.flush();
        } catch (Exception e) {
            throw new RuntimeException("存储文件时发生异常");
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return url;
    }
}
