package com.baizhi.controller;

import com.baizhi.entity.TDepartment;
import com.baizhi.entity.TDoctor;
import com.baizhi.entity.TPatient;
import com.baizhi.entity.TTriage;
import com.baizhi.service.DepartmentService;
import com.baizhi.service.PatientService;
import com.baizhi.service.TriageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("triage")
public class TriageController {
    @Autowired
    private TriageService triageService;
    @Autowired
    private PatientService patientService;
    @Autowired
    private DepartmentService departmentService;
    //挂号展示
    @RequestMapping("/selectById")
    public String selectById(int id, Map map){
        TPatient tPatient=patientService.selectById(id);
        List<TDepartment> list = departmentService.selectAll();
        map.put("tPatient",tPatient);
        map.put("list",list);
        return "manager/patient/PatientRegister";
    }
    //挂号添加
    @RequestMapping("/insert")
    public String insert(TTriage tTriage){
        patientService.updatePatientStatus(tTriage.getPid());
        triageService.insert(tTriage);
        return "/PatientList";
    }
    //开诊展示
    @RequestMapping("/getAll")
    public String getAll(HttpSession httpSession,Map map){
        TDoctor tDoctor = (TDoctor) httpSession.getAttribute("tDoctor");
        TDepartment tDepartment=triageService.selectById(tDoctor.getDeptId());
        int count=triageService.getCount(tDoctor.getDeptId());
        map.put("tDepartment",tDepartment);
        map.put("count",count);
        return "manager/triage/TriageDepartmentList";
    }
    //查询所有叫过号的人
    @RequestMapping("/selectAllTriage")
    public String selectAllTriage(Map map,HttpSession httpSession){
        TDoctor tDoctor =(TDoctor) httpSession.getAttribute("tDoctor");
        List<TTriage> list=triageService.selectAllTriage(tDoctor.getDeptId());
        TDepartment tDepartment=triageService.selectById(tDoctor.getDeptId());
        map.put("tDepartment",tDepartment);
        map.put("list",list);
        return "manager/triage/TriageList";
    }
    //修改诊断状态
    @RequestMapping("/updateTriageStatus")
    public String updateTriageStatus(int id){
        triageService.updateTriageStatus(id);
        return "redirect:selectAllTriage";
    }

    //诊断回显
    @RequestMapping("/selectDoctorAndPatient")
    public String selectDoctorAndPatient(int id,HttpSession httpSession,Map map){
        TDoctor tDoctor =(TDoctor) httpSession.getAttribute("tDoctor");
        TDepartment tDepartment=triageService.selectById(tDoctor.getDeptId());
        TPatient tPatient=patientService.selectById(id);
        map.put("tDoctor",tDoctor);
        map.put("tDepartment",tDepartment);
        map.put("tPatient",tPatient);
        return "manager/triage/AddTriage";

    }

    //诊断结果
    @RequestMapping("/updateTriage")
    public String updateTriage(TTriage tTriage){
        tTriage.setStatus(1);
        triageService.updateTriage(tTriage);
        return "redirect:selectAllTriage";
    }

}
