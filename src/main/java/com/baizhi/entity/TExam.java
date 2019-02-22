package com.baizhi.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (TExam)实体类
 *
 * @author makejava
 * @since 2019-01-02 20:20:53
 */
public class TExam implements Serializable {
    private static final long serialVersionUID = -14982442037715865L;
    
    private Integer id;
    
    private Integer examStatus;
    
    private String examAdvice;
    
    private Date examStartDate;
    
    private Date examEndDate;
    
    private Integer dId;

    public TExam(){}

    public TExam(Integer id, Integer examStatus, String examAdvice, Date examStartDate, Date examEndDate, Integer dId) {
        this.id = id;
        this.examStatus = examStatus;
        this.examAdvice = examAdvice;
        this.examStartDate = examStartDate;
        this.examEndDate = examEndDate;
        this.dId = dId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getExamStatus() {
        return examStatus;
    }

    public void setExamStatus(Integer examStatus) {
        this.examStatus = examStatus;
    }

    public String getExamAdvice() {
        return examAdvice;
    }

    public void setExamAdvice(String examAdvice) {
        this.examAdvice = examAdvice;
    }

    public Date getExamStartDate() {
        return examStartDate;
    }

    public void setExamStartDate(Date examStartDate) {
        this.examStartDate = examStartDate;
    }

    public Date getExamEndDate() {
        return examEndDate;
    }

    public void setExamEndDate(Date examEndDate) {
        this.examEndDate = examEndDate;
    }

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

    @Override
    public String toString() {
        return "TExam{" +
                "id=" + id +
                ", examStatus=" + examStatus +
                ", examAdvice='" + examAdvice + '\'' +
                ", examStartDate=" + examStartDate +
                ", examEndDate=" + examEndDate +
                ", dId=" + dId +
                '}';
    }
}