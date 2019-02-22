package com.baizhi.dao;

import com.baizhi.entity.TDepartment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DepartmentDao {
    List<TDepartment> selectByPage(@Param("start") int start,@Param("rows") int rows,@Param("name") String name);

    int getCount(@Param("name")String name);

    //添加
    void insertDepartment(TDepartment tDepartment);
    //修改
    void updateDepartment(TDepartment tDepartment);
    //批量删除
    void multiDelete(int[] ids);

    List<TDepartment> selectAll();
 }
