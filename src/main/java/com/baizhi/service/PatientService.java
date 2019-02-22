package com.baizhi.service;

import com.baizhi.entity.TPatient;

import java.util.Map;

public interface PatientService {
    Map selectByPage(int page,int rows,String name);

    void insertPatient(TPatient tPatient);

    void updatePatient(TPatient tPatient);

    void multiDelete(int[] id);

    TPatient selectById(int id);

    void updatePatientStatus(int id);
}