package com.baizhi.service;

import com.baizhi.entity.TDepartment;
import com.baizhi.entity.TTriage;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TriageService {
    void insert(TTriage tTriage);

    TDepartment selectById(int id);

    int getCount(int id);

    List<TTriage> selectAllTriage(int id);

    void updateTriageStatus(int id);

    void updateTriage(TTriage tTriage);
}
