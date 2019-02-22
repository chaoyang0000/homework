package com.baizhi.service;

import com.baizhi.entity.TDrug;

import java.util.List;
import java.util.Map;

public interface DrugService {

    Map selectByPage(int page,int rows,String name);

    void insertDrug(TDrug tDrug);

    void updateDrug(TDrug tDrug);

    void multiDelete(int[] ids);

    void updateSaleStatus(int saleStatus,int id);

    int getId(String name);

    TDrug getDrug(int id);
    List<TDrug> getAllExamAndDrug();


}
