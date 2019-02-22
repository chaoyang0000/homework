package com.baizhi.service.impl;

import com.baizhi.dao.PatientDao;
import com.baizhi.entity.TPatient;
import com.baizhi.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientDao patientDao;
    @Override
    public Map selectByPage(int page, int rows, String name) {
        Map map=new HashMap();
        int start=(page-1)*rows;
        List<TPatient> list=patientDao.selectByPage(start,rows,name);
        int count=patientDao.getCount(name);
        map.put("rows",list);
        map.put("total",count);
        return map;
    }

    @Override
    public void insertPatient(TPatient tPatient) {
        patientDao.insertPatient(tPatient);
    }

    @Override
    public void updatePatient(TPatient tPatient) {
        patientDao.updatePatient(tPatient);
    }

    @Override
    public void multiDelete(int[] id) {
        patientDao.multiDelete(id);
    }

    @Override
    public TPatient selectById(int id) {
        TPatient tPatient=patientDao.selectById(id);
        return tPatient;
    }

    @Override
    public void updatePatientStatus(int id) {
        patientDao.updatePatientStatus(id);
    }
}
