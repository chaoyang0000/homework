package com.baizhi.controller;

import com.baizhi.entity.TDepartment;
import com.baizhi.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    @RequestMapping("/selectByPage")
    public @ResponseBody Map selectByPage(int page, int rows, String name){
        Map map=departmentService.selectByPage(page,rows,name);
        return map;
    }
    @RequestMapping("/insertDepartment")
    public @ResponseBody boolean insertDepartment(TDepartment tDepartment){
        try{
            departmentService.insertDepartment(tDepartment);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    @RequestMapping("/updateDepartment")
    public @ResponseBody boolean updateDepartment(TDepartment tDepartment){
        try{
            departmentService.updateDepartment(tDepartment);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    @RequestMapping("/multiDelete")
    public @ResponseBody boolean multiDelete(int[] ids){
        for (int id : ids) {
            System.out.println("________"+id);
        }
        try{
            departmentService.multiDelete(ids);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
