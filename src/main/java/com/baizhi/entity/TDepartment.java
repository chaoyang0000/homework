package com.baizhi.entity;

import java.io.Serializable;

/**
 * (TDepartment)实体类
 *
 * @author makejava
 * @since 2018-12-31 18:46:52
 */
public class TDepartment implements Serializable {
    private static final long serialVersionUID = 917750361095051279L;
    
    private Integer id;
    
    private String name;
    
    private String telephone;
    
    private String area;
    public TDepartment(){}

    public TDepartment(Integer id, String name, String telephone, String area) {
        this.id = id;
        this.name = name;
        this.telephone = telephone;
        this.area = area;
    }

    @Override
    public String toString() {
        return "TDepartment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", telephone='" + telephone + '\'' +
                ", area='" + area + '\'' +
                '}';
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

}