package com.baizhi.service.impl;

import com.baizhi.dao.DepartmentDao;
import com.baizhi.entity.TDepartment;
import com.baizhi.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Resource
    private DepartmentDao departmentDao;
    @Override
    public Map selectByPage(int page, int rows, String name) {
        Map map=new HashMap();
        int start=(page-1)*rows;
        List<TDepartment> list=departmentDao.selectByPage(start,rows,name);
        int count=departmentDao.getCount(name);
        map.put("rows",list);
        map.put("total",count);
        return map;
    }

    @Override
    public void insertDepartment(TDepartment tDepartment) {
        departmentDao.insertDepartment(tDepartment);
    }

    @Override
    public void updateDepartment(TDepartment tDepartment) {
        departmentDao.updateDepartment(tDepartment);
    }

    @Override
    public void multiDelete(int[] ids) {
        departmentDao.multiDelete(ids);
    }

    @Override
    public List<TDepartment> selectAll() {
        List<TDepartment> list = departmentDao.selectAll();
        return list;
    }
}
