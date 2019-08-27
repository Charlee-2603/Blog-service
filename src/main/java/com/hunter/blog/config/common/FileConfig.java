package com.hunter.blog.config.common;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.MultipartConfigElement;

/**
 * @description 图片大小配置
 * @author ChenLiang
 * @data: 2019/8/26 20:21
 * @version 1.0.0
 */
@Configuration
public class FileConfig {
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize(1024L * 1024L);
        return factory.createMultipartConfig();
    }
}
