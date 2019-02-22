package com.baizhi.controller;

import com.baizhi.entity.UserDTO;
import com.baizhi.service.UserService;
import com.baizhi.service.impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @Resource
    private UserService userService;
    UserServiceImpl userService1=new UserServiceImpl();

    @RequestMapping("/getAllSexCount")
    public @ResponseBody Map getAllSexCount(){
        Map map=userService.getAllSexCount();
        return map;
    }

    @RequestMapping("/getAllUserCount")
    public @ResponseBody Map getAllUserCount(){
        Map map=userService.getAllUserCount();
        return map;
    }
    @RequestMapping("/getAllProvinceCity")
    public @ResponseBody List<UserDTO> getAllProvinceCity(){
        List<UserDTO> list=userService.getAllProvinceCity();
        return list;
    }
    //单线程合并
    @RequestMapping("/getAllDate")
    public @ResponseBody Map getAllDate(){
        Map map=userService.getAllDate();
        return map;
    }
    //多线程合并
    @RequestMapping("/getAllDate1")
    public @ResponseBody Map getAllDate1(){
        Map allDate1 = userService.getAllDate1();
        return allDate1;
    }

}
