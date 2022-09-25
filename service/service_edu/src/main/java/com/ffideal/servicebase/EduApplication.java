package com.ffideal.servicebase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author: ffideal
 * @CreateTime: 2022-08-14  14:21
 * @Description: TODO
 * @Version: 1.0
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.ffideal"})//设置扫描组件的的目标包路径
public class EduApplication {
    public static void main(String[] args) {
        SpringApplication.run(EduApplication.class, args);
    }
}
