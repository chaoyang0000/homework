package com.baizhi.service;

import com.baizhi.entity.TDepartment;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Map selectByPage(int page,int rows,String name);

    //添加
    void insertDepartment(TDepartment tDepartment);

    //修改
    void updateDepartment(TDepartment tDepartment);
    //批量删除
    void multiDelete(int[] ids);

    List<TDepartment> selectAll();
}
