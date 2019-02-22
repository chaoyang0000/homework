package com.baizhi.controller;

import com.baizhi.entity.TDrug;
import com.baizhi.service.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class DrugController {
    @Autowired
    private DrugService drugService;
    @RequestMapping("/selectByPageDrug")
    public @ResponseBody Map selectByPageDrug(int page, int rows, String name){
        Map map=drugService.selectByPage(page,rows,name);

        return map;
    }
    @RequestMapping("/insertDrug")
    public String insertDrug(TDrug tDrug,Map map){
        drugService.insertDrug(tDrug);
        int id=drugService.getId(tDrug.getName());
        tDrug.setId(id);
        map.put("drug",tDrug);
        return "/manager/drug/ExamDrug";
    }
    @RequestMapping("/updateDrug")
    public @ResponseBody boolean updateDrug(TDrug tDrug){
        try{
            drugService.updateDrug(tDrug);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    @RequestMapping("multiDeleteDrug")
    public @ResponseBody boolean multiDeleteDrug(int[] ids){
        try{
            drugService.multiDelete(ids);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    @RequestMapping("/updateSaleStatus")
    public String updateSaleStatus(int saleStatus,int id){
        drugService.updateSaleStatus(saleStatus,id);
        return "DrugList";
    }
    @RequestMapping("/getAllExamAndDrug")
    public String getAllExamAndDrug(Map map){
        List<TDrug> list=drugService.getAllExamAndDrug();
        map.put("list",list);
        return "/manager/drug/ExamDrugsList";
    }
}
