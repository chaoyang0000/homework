package com.baizhi.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (TDrug)实体类
 *
 * @author makejava
 * @since 2019-01-02 09:28:47
 */
public class TDrug implements Serializable {

    private Integer id;
    
    private String name;
    
    private String spec;
    
    private String unit;
    
    private String productCompany;
    
    private Date productDate;
    
    private Date okDate;
    
    private double importPrice;
    
    private double price;
    
    private Integer saleStatus;
    
    private Integer isImport;
    
    private String description;

    private TExam tExam;

    public TDrug(){}

    public TDrug(Integer id, String name, String spec, String unit, String productCompany, Date productDate, Date okDate, double importPrice, double price, Integer saleStatus, Integer isImport, String description, TExam tExam) {
        this.id = id;
        this.name = name;
        this.spec = spec;
        this.unit = unit;
        this.productCompany = productCompany;
        this.productDate = productDate;
        this.okDate = okDate;
        this.importPrice = importPrice;
        this.price = price;
        this.saleStatus = saleStatus;
        this.isImport = isImport;
        this.description = description;
        this.tExam = tExam;
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

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getProductCompany() {
        return productCompany;
    }

    public void setProductCompany(String productCompany) {
        this.productCompany = productCompany;
    }

    public Date getProductDate() {
        return productDate;
    }

    public void setProductDate(Date productDate) {
        this.productDate = productDate;
    }

    public Date getOkDate() {
        return okDate;
    }

    public void setOkDate(Date okDate) {
        this.okDate = okDate;
    }

    public double getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(double importPrice) {
        this.importPrice = importPrice;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getSaleStatus() {
        return saleStatus;
    }

    public void setSaleStatus(Integer saleStatus) {
        this.saleStatus = saleStatus;
    }

    public Integer getIsImport() {
        return isImport;
    }

    public void setIsImport(Integer isImport) {
        this.isImport = isImport;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TExam gettExam() {
        return tExam;
    }

    public void settExam(TExam tExam) {
        this.tExam = tExam;
    }

    @Override
    public String toString() {
        return "TDrug{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", spec='" + spec + '\'' +
                ", unit='" + unit + '\'' +
                ", productCompany='" + productCompany + '\'' +
                ", productDate=" + productDate +
                ", okDate=" + okDate +
                ", importPrice=" + importPrice +
                ", price=" + price +
                ", saleStatus=" + saleStatus +
                ", isImport=" + isImport +
                ", description='" + description + '\'' +
                ", tExam=" + tExam +
                '}';
    }
}