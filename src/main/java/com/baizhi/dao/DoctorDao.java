package com.baizhi.dao;

import com.baizhi.entity.TDoctor;

public interface DoctorDao {
    TDoctor getDoctor(TDoctor tDoctor);

    //添加一个医生
    void insertDoctor(TDoctor tDoctor);
}
