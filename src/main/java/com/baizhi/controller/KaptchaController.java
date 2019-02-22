package com.baizhi.controller;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;

@Controller
public class KaptchaController {
    @Autowired
    private DefaultKaptcha defaultKaptcha;
    @RequestMapping("/getImage")
    public void getImage(HttpSession session, HttpServletResponse response)throws Exception{
        //调用方法生成验证码文本
        String text=defaultKaptcha.createText();
        //把验证码文本存到session中
        session.setAttribute("kaptcha",text);
        //根据文本生成图片
        BufferedImage image=defaultKaptcha.createImage(text);
        //以流的方式进行响应
        ImageIO.write(image,"jpg",response.getOutputStream());
    }
}
