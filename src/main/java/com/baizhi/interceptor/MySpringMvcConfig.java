/*
package com.baizhi.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootConfiguration
public class MySpringMvcConfig extends WebMvcConfigurerAdapter {
    @Autowired
    private DoctorConfig doctorConfig;

    public void addInterceptors(InterceptorRegistry registry){

        registry.addInterceptor(doctorConfig).addPathPatterns("/**").excludePathPatterns("/getImage").excludePathPatterns("/login");



    }
}
*/
