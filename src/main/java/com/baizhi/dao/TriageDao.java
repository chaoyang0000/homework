package com.baizhi.dao;

import com.baizhi.entity.TDepartment;
import com.baizhi.entity.TTriage;

import java.util.List;

public interface TriageDao {
    //挂号
    void insert(TTriage tTriage);

  //根据部门id查询所属科室
    TDepartment selectById(int id);
    //查询某个科室要诊断的人数
    int getCount(int id);
    //查询所有挂号的人
    List<TTriage> selectAllTriage(int id);
    //叫号修改状态
    void updateTriageStatus(int id);

    //诊断
    void updateTriage(TTriage tTriage);
}
