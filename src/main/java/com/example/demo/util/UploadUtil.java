package com.example.demo.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class UploadUtil {
    public static String uploadFile(MultipartFile multipartFile,String filePath)throws IOException {
        //上传文件名
        String originlFilename=multipartFile.getOriginalFilename();
        //避免重名，做标记
        String fileName=new StringBuffer(String.valueOf(System.currentTimeMillis())).append(originlFilename).toString();
        //文件上传路径级文件夹名
        File file=new File(filePath+fileName);
        //执行文件上传操作
        multipartFile.transferTo(file);

        return  fileName;

    }
}
