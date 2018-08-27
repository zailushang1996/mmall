package com.mmall.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Author:liuzhixiang
 * Create by LiuZX on 2018/8/27
 *
 * @ Description:
 */
public interface IFileService {

    public String upload(MultipartFile file, String path);
}
