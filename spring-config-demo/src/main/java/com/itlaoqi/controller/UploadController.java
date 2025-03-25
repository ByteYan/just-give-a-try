package com.itlaoqi.controller;

import com.itlaoqi.config.UploadComponent;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UploadController {

    @Resource
    UploadComponent uploadComponent;

    @Resource
    RestTemplate restTemplate;

    @GetMapping("/uploader")
    public void upload(){
        uploadComponent.upload();
    }

}
