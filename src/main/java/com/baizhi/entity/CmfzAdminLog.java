package com.baizhi.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (CmfzAdminLog)实体类
 *
 * @author makejava
 * @since 2019-01-11 19:33:27
 */
public class CmfzAdminLog implements Serializable {

    private Integer logId;
    
    private String logAction;
    
    private String adminUsername;
    
    private Integer adminId;
    
    private Date logDate;
    
    private String logIp;
    
    private String logResult;

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public String getLogAction() {
        return logAction;
    }

    public void setLogAction(String logAction) {
        this.logAction = logAction;
    }

    public String getAdminUsername() {
        return adminUsername;
    }

    public void setAdminUsername(String adminUsername) {
        this.adminUsername = adminUsername;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public Date getLogDate() {
        return logDate;
    }

    public void setLogDate(Date logDate) {
        this.logDate = logDate;
    }

    public String getLogIp() {
        return logIp;
    }

    public void setLogIp(String logIp) {
        this.logIp = logIp;
    }

    public String getLogResult() {
        return logResult;
    }

    public void setLogResult(String logResult) {
        this.logResult = logResult;
    }
    public CmfzAdminLog(){};
    public CmfzAdminLog(Integer logId, String logAction, String adminUsername, Integer adminId, Date logDate, String logIp, String logResult) {
        this.logId = logId;
        this.logAction = logAction;
        this.adminUsername = adminUsername;
        this.adminId = adminId;
        this.logDate = logDate;
        this.logIp = logIp;
        this.logResult = logResult;
    }

    @Override
    public String toString() {
        return "CmfzAdminLog{" +
                "logId=" + logId +
                ", logAction='" + logAction + '\'' +
                ", adminUsername='" + adminUsername + '\'' +
                ", adminId=" + adminId +
                ", logDate=" + logDate +
                ", logIp='" + logIp + '\'' +
                ", logResult='" + logResult + '\'' +
                '}';
    }
}

