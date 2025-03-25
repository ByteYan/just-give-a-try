package com.itlaoqi.config;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class UploadComponent {

    private AppConfigProperties appConfigProperties;
    public void upload(){
      log.info("app.config:{}",appConfigProperties);
    }
}
