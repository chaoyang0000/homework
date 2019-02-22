package com.baizhi.entity;

import java.io.Serializable;

/**
 * (TTriage)实体类
 *
 * @author makejava
 * @since 2019-01-21 20:48:13
 */
public class TTriage implements Serializable {
    private static final long serialVersionUID = -97901563924676997L;
    
    private Integer id;
    
    private Integer status;
    
    private String illnessInfo;
    
    private String advice;
    
    private Integer pid;
    
    private Integer did;
    
    private Integer uid;

    private TPatient tPatient;

    public TTriage(){}

    public TTriage(Integer id, Integer status, String illnessInfo, String advice, Integer pid, Integer did, Integer uid, TPatient tPatient) {
        this.id = id;
        this.status = status;
        this.illnessInfo = illnessInfo;
        this.advice = advice;
        this.pid = pid;
        this.did = did;
        this.uid = uid;
        this.tPatient = tPatient;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getIllnessInfo() {
        return illnessInfo;
    }

    public void setIllnessInfo(String illnessInfo) {
        this.illnessInfo = illnessInfo;
    }

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public TPatient gettPatient() {
        return tPatient;
    }

    public void settPatient(TPatient tPatient) {
        this.tPatient = tPatient;
    }

    @Override
    public String toString() {
        return "TTriage{" +
                "id=" + id +
                ", status=" + status +
                ", illnessInfo='" + illnessInfo + '\'' +
                ", advice='" + advice + '\'' +
                ", pid=" + pid +
                ", did=" + did +
                ", uid=" + uid +
                ", tPatient=" + tPatient +
                '}';
    }
}