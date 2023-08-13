package com.wf.first.app.controller;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.wf.first.app.common.BaseResult;
import com.wf.first.app.service.CommonService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/common")
@AllArgsConstructor
public class CommonController {

    private CommonService commonService;


    @PostMapping("/upload")
    public BaseResult<String> upload(@RequestBody MultipartFile file) {
        if (file == null) {
            return BaseResult.fail("文件不能为空");
        }
        String fileName = file.getOriginalFilename();
        String extension = fileName.substring(fileName.lastIndexOf(".") + 1);
        if (!StringUtils.equals(extension, "jpg") && !StringUtils.equals(extension, "jpeg")) {
            return BaseResult.fail("文件格式不正确：暂时只支持jpg || jpeg格式的图片");
        }
        if (file.getSize() > 5*1024*1024) {
            return BaseResult.fail("文件大小超过5M");
        }

        try {
            String url = commonService.upload(file);
            return BaseResult.success(url);
        } catch (Exception e) {
            return BaseResult.fail(e.getMessage());
        }
    }
}
