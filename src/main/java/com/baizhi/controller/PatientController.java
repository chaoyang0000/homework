package com.baizhi.controller;

import com.baizhi.entity.TPatient;
import com.baizhi.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class PatientController {
    @Autowired
    private PatientService patientService;
    @RequestMapping("/selectPatientByPage")
    public @ResponseBody Map selectPatientByPage(int page, int rows, String name){
        Map map=patientService.selectByPage(page,rows,name);
        return map;
    }

    @RequestMapping("/insertPatient")
    public @ResponseBody boolean insertPatient(TPatient tPatient){
        System.out.println("&&&&&"+tPatient);
        try{
            patientService.insertPatient(tPatient);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @RequestMapping("/updatePatient")
    public @ResponseBody boolean updatePatient(TPatient tPatient){
        System.out.println("&&&&&"+tPatient);
        try{
            patientService.updatePatient(tPatient);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @RequestMapping("/multiDelete1")
    public @ResponseBody boolean multiDelete1(int[] id){

        try{
            patientService.multiDelete(id);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
