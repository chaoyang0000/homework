package com.baizhi.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (TPatient)实体类
 *
 * @author makejava
 * @since 2019-01-01 10:41:25
 */
public class TPatient implements Serializable {
    private static final long serialVersionUID = -71890516477794019L;
    
    private Integer id;
    
    private String name;
    
    private Integer sex;
    
    private Date birth;
    
    private String idcard;
    
    private String address;
    
    private String mobile;

    private Integer status;
    public TPatient(){}

    public TPatient(Integer id, String name, Integer sex, Date birth, String idcard, String address, String mobile, Integer status) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.birth = birth;
        this.idcard = idcard;
        this.address = address;
        this.mobile = mobile;
        this.status = status;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}