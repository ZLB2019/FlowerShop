package com.zlb.flower_shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.util.unit.DataSize;

import javax.servlet.MultipartConfigElement;

@SpringBootApplication
public class FlowerShopApplication {
    public static void main(String[] args) {
        SpringApplication.run(FlowerShopApplication.class, args);
    }

    @Bean
    public MultipartConfigElement multipartConfigElement() {
            MultipartConfigFactory factory = new MultipartConfigFactory();
            //单个文件最大
            factory.setMaxFileSize(DataSize.ofMegabytes(80)); //MB
             /// 设置总上传数据总大小
             factory.setMaxRequestSize(DataSize.ofMegabytes(100));
             return factory.createMultipartConfig();
         }
}
