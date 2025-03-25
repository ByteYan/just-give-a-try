package com.itlaoqi.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

// 声明这是一个Spring的配置类
// Spring会特别关注这个类
// 会将其作为Bean定义的源
@Configuration
public class AppConfiguration {

    // 使用@Value注解注入配置文件中的spring.application.name属性的值到appName字段  
    @Value("${spring.application.name}")
    public String appName;

    // 定义一个Bean，RestTemplate的实例将会被Spring管理 ,BeanID=restTemplate
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    // 定义一个Bean，AppConfigProperties的实例将会被Spring管理  
    // 使用@ConfigurationProperties注解，将配置文件中以"app.config"为前缀的配置项自动绑定到AppConfigProperties类的对应字段上  
    @Bean
    @ConfigurationProperties(prefix = "app.config")
    public AppConfigProperties appConfigProperties(){
        return new AppConfigProperties();
    }

    @Bean
    public AppConfigProperties appConfigPropertiesNon(){
        return new AppConfigProperties();
    }

    // 定义一个Bean，UploadComponent的实例将会被Spring管理  
    // 通过@Qualifier注解指定注入的AppConfigProperties Bean的名称
    // 确保注入的是我们刚刚定义的appConfigProperties Bean
    // 在UploadComponent实例被创建后
    // 设置其AppConfigProperties属性为我们注入的AppConfigProperties实例
    @Bean
    public UploadComponent uploadComponent(@Qualifier("appConfigProperties") AppConfigProperties properties) {
        UploadComponent uploadComponent = new UploadComponent();
        uploadComponent.setAppConfigProperties(properties);
        return uploadComponent;
    }
}