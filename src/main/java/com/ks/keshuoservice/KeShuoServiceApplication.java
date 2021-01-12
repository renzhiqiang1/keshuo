package com.ks.keshuoservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
/*
* jar启动
* */
@MapperScan(basePackages = "com.ks.keshuoservice.dao") //扫描的mapper
@SpringBootApplication
@EnableScheduling
@EnableSwagger2
@EnableCaching
public class KeShuoServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(KeShuoServiceApplication.class, args);
    }

}

























/*
@MapperScan(basePackages = "com.tj.sz.wechatservice.dao") //扫描的mapper
@SpringBootApplication
@EnableScheduling //定时
@EnableFeignClients//feign微服务内部调用
//@EnableEurekaClient
public class WechatServiceApplication extends SpringBootServletInitializer{

    public static void main(String[] args) {
        SpringApplication.run(WechatServiceApplication.class, args);
    }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WechatServiceApplication.class);
    }
}*/

 
///**
// * jar启动方法
// */

//@MapperScan(basePackages = "com.tj.sz.wechatservice.dao,com.tj.sz.wechatservice.mapper") //扫描的mapper
//@SpringBootApplication
//@EnableScheduling
////@EnableAsync @Async异步和多线程还是有区别的
////@EnableFeignClients//feign微服务内部调用
////@EnableEurekaClient
//@EnableSwagger2
////@EnableDiscoveryClient
//@EnableCaching
//public class WechatServiceApplication {
//
//    public static void main(String[] args) {
//        SpringApplication.run(WechatServiceApplication.class, args);
//    }
//
//}
