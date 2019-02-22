package com.baizhi.service.impl;

import com.baizhi.dao.TriageDao;
import com.baizhi.entity.TDepartment;
import com.baizhi.entity.TTriage;
import com.baizhi.service.TriageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TriageServiceImpl implements TriageService {
    //挂号
    @Resource
    private TriageDao triageDao;
        @Override
    public void insert(TTriage tTriage) {
        triageDao.insert(tTriage);
    }

    @Override
    public TDepartment selectById(int id) {
        TDepartment tDepartment=triageDao.selectById(id);
            return tDepartment;
    }

    @Override
    public int getCount(int id) {
        int count = triageDao.getCount(id);
        return count;
    }

    @Override
    public List<TTriage> selectAllTriage(int id) {
        List<TTriage> tTriages = triageDao.selectAllTriage(id);
          return tTriages;
    }

    @Override
    public void updateTriageStatus(int id) {
            triageDao.updateTriageStatus(id);
    }

    @Override
    public void updateTriage(TTriage tTriage) {
        triageDao.updateTriage(tTriage);
    }
}
