package com.baizhi.service;

import com.baizhi.entity.TExam;

import java.util.List;

public interface ExamService {
    void insertExam(TExam tExam);

    TExam getExam(int id);


}
