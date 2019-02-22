package com.baizhi.dao;

import com.baizhi.entity.TExam;

import java.util.List;

public interface ExamDao {
    void insertExam(TExam tExam);

    TExam getExam(int id);


}
