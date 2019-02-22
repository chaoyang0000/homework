package com.baizhi.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (CmfzUser)实体类
 *
 * @author makejava
 * @since 2019-01-08 21:03:39
 */
public class CmfzUser implements Serializable {
    private static final long serialVersionUID = -94264927436348212L;
    
    private Integer userId;
    
    private String telphone;
    
    private String password;
    
    private String userImage;
    
    private String nickname;
    
    private String name;
    
    private String sex;
    
    private String autograph;
    
    private String userProvince;
    
    private String userCity;
    
    private Integer guruId;
    
    private Integer userStatus;

    private Date createDate;

    public CmfzUser() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAutograph() {
        return autograph;
    }

    public void setAutograph(String autograph) {
        this.autograph = autograph;
    }

    public String getUserProvince() {
        return userProvince;
    }

    public void setUserProvince(String userProvince) {
        this.userProvince = userProvince;
    }

    public String getUserCity() {
        return userCity;
    }

    public void setUserCity(String userCity) {
        this.userCity = userCity;
    }

    public Integer getGuruId() {
        return guruId;
    }

    public void setGuruId(Integer guruId) {
        this.guruId = guruId;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "CmfzUser{" +
                "userId=" + userId +
                ", telphone='" + telphone + '\'' +
                ", password='" + password + '\'' +
                ", userImage='" + userImage + '\'' +
                ", nickname='" + nickname + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", autograph='" + autograph + '\'' +
                ", userProvince='" + userProvince + '\'' +
                ", userCity='" + userCity + '\'' +
                ", guruId=" + guruId +
                ", userStatus=" + userStatus +
                ", createDate=" + createDate +
                '}';
    }
}