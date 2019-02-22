package com.baizhi.service;

import com.baizhi.entity.TDoctor;

public interface DoctorService {
    TDoctor getTDoctor(TDoctor tDoctor);

    void insertDoctor(TDoctor tDoctor);
}
