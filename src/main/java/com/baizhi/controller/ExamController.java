package com.baizhi.controller;

import com.baizhi.entity.TDrug;
import com.baizhi.entity.TExam;
import com.baizhi.service.DrugService;
import com.baizhi.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
public class ExamController {
    @Autowired
    private ExamService examService;
    @Autowired
    private DrugService drugService;
    @RequestMapping("/insertExam")
    public String insertExam(TExam tExam){
        System.out.println("+++++"+tExam);
        examService.insertExam(tExam);
        return "DrugList";
    }
    @RequestMapping("/updateExamStatus")
    public String updateExamStatus(int id, Map map){
        TExam tExam=examService.getExam(id);
        TDrug tDrug=drugService.getDrug(id);
        map.put("exam",tExam);
        map.put("drug",tDrug);
        return "/manager/drug/ExamDrug";
    }

}
