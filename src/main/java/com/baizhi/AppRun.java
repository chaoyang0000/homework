package com.baizhi;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Properties;

/**
 * 启动规则
 * 1.启动位置 主包下面和子包同级
 * 2.需要一个@SpringBootApplication
 */
@SpringBootApplication
@MapperScan("com.baizhi.dao")//相当于applicationContext.xml中的创建dao层代理类对象
public class AppRun {
    public static void main(String[] args) {
        //参数： 启动类对象  主函数形参名
        SpringApplication.run(AppRun.class,args);
    }
    /**
     * 验证配置
     * @return
     */
    @Bean
    public DefaultKaptcha producer() {
        Properties properties = new Properties();
        properties.put("kaptcha.border", "no");
        properties.put("kaptcha.textproducer.font.color", "red");
        properties.put("kaptcha.textproducer.char.space", "5");
        Config config = new Config(properties);
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        defaultKaptcha.setConfig(config);
        return defaultKaptcha;
    }
}
