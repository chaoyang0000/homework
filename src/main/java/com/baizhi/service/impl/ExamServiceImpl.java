package com.baizhi.service.impl;

import com.baizhi.dao.ExamDao;
import com.baizhi.entity.TExam;
import com.baizhi.service.ExamService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ExamServiceImpl implements ExamService {
    @Resource
    private ExamDao examDao;
    @Override
    public void insertExam(TExam tExam) {
        examDao.insertExam(tExam);
    }

    @Override
    public TExam getExam(int id) {
        TExam exam=examDao.getExam(id);
        return exam;
    }


}
