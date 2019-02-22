package com.baizhi.service.impl;

import com.baizhi.dao.DrugDao;
import com.baizhi.entity.TDrug;
import com.baizhi.service.DrugService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class DrugServiceImpl implements DrugService {
    @Resource
    private DrugDao drugDao;
    @Override
    public Map selectByPage(int page, int rows, String name) {
        Map map=new HashMap();
        int start=(page-1)*rows;
        List<TDrug> list=drugDao.selectByPage(start,rows,name);
        map.put("rows",list);
        for (TDrug tDrug : list) {
            System.out.println("****"+tDrug);
        }
        int count=drugDao.getCount(name);
        map.put("total",count);
        return map;
    }

    @Override
    public void insertDrug(TDrug tDrug) {
        drugDao.insertDrug(tDrug);
    }

    @Override
    public void updateDrug(TDrug tDrug) {
        drugDao.updateDrug(tDrug);
    }

    @Override
    public void multiDelete(int[] ids) {
        drugDao.multiDelete(ids);
    }

    @Override
    public void updateSaleStatus(int saleStatus, int id) {
        drugDao.updateSaleStatus(saleStatus,id);
    }

    @Override
    public int getId(String name) {
        int id=drugDao.getId(name);
        return id;
    }

    @Override
    public TDrug getDrug(int id) {
        TDrug tDrug=drugDao.getDrug(id);
        return tDrug;
    }

    @Override
    public List<TDrug> getAllExamAndDrug() {
        List<TDrug> list=drugDao.getAllExamAndDrug();
        return list;
    }
}
