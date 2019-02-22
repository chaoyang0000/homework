package com.baizhi.service.impl;

import com.baizhi.dao.DoctorDao;
import com.baizhi.entity.TDoctor;
import com.baizhi.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Resource
    private DoctorDao doctorDao;

    @Override
    public TDoctor getTDoctor(TDoctor tDoctor) {
        TDoctor tDoctor1=doctorDao.getDoctor(tDoctor);
        return tDoctor1;
    }

    @Override
    public void insertDoctor(TDoctor tDoctor) {
        doctorDao.insertDoctor(tDoctor);
    }
}
