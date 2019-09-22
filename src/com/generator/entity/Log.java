package com.generator.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Log {
    private BigDecimal id;

    private String operateor;

    private String operatetype;

    private Date operatedate;

    private String operateresult;

    private String ip;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getOperateor() {
        return operateor;
    }

    public void setOperateor(String operateor) {
        this.operateor = operateor;
    }

    public String getOperatetype() {
        return operatetype;
    }

    public void setOperatetype(String operatetype) {
        this.operatetype = operatetype;
    }

    public Date getOperatedate() {
        return operatedate;
    }

    public void setOperatedate(Date operatedate) {
        this.operatedate = operatedate;
    }

    public String getOperateresult() {
        return operateresult;
    }

    public void setOperateresult(String operateresult) {
        this.operateresult = operateresult;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}