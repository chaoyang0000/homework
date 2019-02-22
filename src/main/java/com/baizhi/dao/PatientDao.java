package com.baizhi.dao;

import com.baizhi.entity.TPatient;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PatientDao {
    List<TPatient> selectByPage(@Param("start") int start,@Param("rows") int rows, @Param("name") String name);

    int getCount(@Param("name") String name);

    void insertPatient(TPatient tPatient);

    void updatePatient(TPatient tPatient);
    //批量删除
    void multiDelete(int[] ids);

    TPatient selectById(int id);

    //修改挂号状态
    void updatePatientStatus(int id);
}
