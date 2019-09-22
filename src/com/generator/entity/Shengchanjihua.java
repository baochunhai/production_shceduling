package com.generator.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Shengchanjihua {
    private String renwuno;

    private BigDecimal touchanshuliang;

    private Date jihuakaishiriqi;

    private Date jiaohuoqi;

    public String getRenwuno() {
        return renwuno;
    }

    public void setRenwuno(String renwuno) {
        this.renwuno = renwuno;
    }

    public BigDecimal getTouchanshuliang() {
        return touchanshuliang;
    }

    public void setTouchanshuliang(BigDecimal touchanshuliang) {
        this.touchanshuliang = touchanshuliang;
    }

    public Date getJihuakaishiriqi() {
        return jihuakaishiriqi;
    }

    public void setJihuakaishiriqi(Date jihuakaishiriqi) {
        this.jihuakaishiriqi = jihuakaishiriqi;
    }

    public Date getJiaohuoqi() {
        return jiaohuoqi;
    }

    public void setJiaohuoqi(Date jiaohuoqi) {
        this.jiaohuoqi = jiaohuoqi;
    }
}