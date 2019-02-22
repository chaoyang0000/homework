package com.baizhi.dao;

import com.baizhi.entity.TDrug;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DrugDao {
    List<TDrug> selectByPage(@Param("start") int start,@Param("rows") int rows, @Param("name") String name);

    int getCount(@Param("name")String name);

    void insertDrug(TDrug tDrug);

    void updateDrug(TDrug tDrug);

    void multiDelete(int[] ids);

    void updateSaleStatus(@Param("saleStatus") int saleStatus,@Param("id")int id);

    int getId(@Param("name") String name);

    TDrug getDrug(int id);

    List<TDrug> getAllExamAndDrug();
}
