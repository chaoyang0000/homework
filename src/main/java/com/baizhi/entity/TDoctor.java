package com.baizhi.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (TDoctor)实体类
 *
 * @author makejava
 * @since 2018-12-31 16:38:21
 */
public class TDoctor implements Serializable {
    private static final long serialVersionUID = -85317390878376040L;
    
    private Integer id;
    
    private String username;
    
    private String password;
    
    private String realname;
    
    private Integer sex;
    
    private Date birth;
    
    private String mobile;
    
    private String email;
    
    private String pic;
    
    private Integer deptId;
    public TDoctor(){}

    @Override
    public String toString() {
        return "TDoctor{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", realname='" + realname + '\'' +
                ", sex=" + sex +
                ", birth=" + birth +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", pic='" + pic + '\'' +
                ", deptId=" + deptId +
                '}';
    }

    public TDoctor(Integer id, String username, String password, String realname, Integer sex, Date birth, String mobile, String email, String pic, Integer deptId) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.realname = realname;
        this.sex = sex;
        this.birth = birth;
        this.mobile = mobile;
        this.email = email;
        this.pic = pic;
        this.deptId = deptId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

}