package com.baizhi.service.impl;

import com.baizhi.dao.AdminLogDao;
import com.baizhi.entity.CmfzAdminLog;
import com.baizhi.service.AdminLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AdminLogServiceImpl implements AdminLogService {
    @Resource
    private AdminLogDao adminLogDao;
    @Override
    public void insert(CmfzAdminLog cmfzAdminLog) {
        adminLogDao.insert(cmfzAdminLog);
    }
}
