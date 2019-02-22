package com.baizhi.controller;

import com.baizhi.entity.TDoctor;
import com.baizhi.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.Map;
import java.util.UUID;

@Controller
public class DoctorController {
    @Autowired
    private DoctorService doctorService;
    @RequestMapping("/login")
    public String login(TDoctor tDoctor, HttpSession httpSession, String code, Map map) {
        TDoctor tDoctor1 = doctorService.getTDoctor(tDoctor);
        String code1 = (String) httpSession.getAttribute("kaptcha");
        String error = null;
        if (!code.equalsIgnoreCase(code1)) {
            error = "验证码输入错误";
            map.put("error",error);
            return "login";
        } else if (tDoctor1 == null) {
            error = "用户或密码输入错误";
            map.put("error",error);
            return "login";
        } else {
            httpSession.setAttribute("tDoctor",tDoctor1);
            return "menu";
        }
    }

    @RequestMapping("/register")
    public String register(TDoctor tDoctor, MultipartFile image)throws Exception{
        System.out.println("************进来了");
        System.out.println("++++++"+tDoctor);
        String s= UUID.randomUUID().toString();
            String newName=s+"_"+image.getOriginalFilename();
            File file=new File("E://上传图片",newName);
            image.transferTo(file);
            tDoctor.setPic("E://上传图片"+newName);
            doctorService.insertDoctor(tDoctor);
            return "login";
    }

}
