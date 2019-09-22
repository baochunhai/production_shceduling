package com.generator.entity;

import java.math.BigDecimal;

public class Palmer {
    private String partno;

    private Integer pi1;

    private Integer pi2;

    private Short pi3;

    private BigDecimal lamda;

    public String getPartno() {
        return partno;
    }

    public void setPartno(String partno) {
        this.partno = partno;
    }

    public Integer getPi1() {
        return pi1;
    }

    public void setPi1(Integer pi1) {
        this.pi1 = pi1;
    }

    public Integer getPi2() {
        return pi2;
    }

    public void setPi2(Integer pi2) {
        this.pi2 = pi2;
    }

    public Short getPi3() {
        return pi3;
    }

    public void setPi3(Short pi3) {
        this.pi3 = pi3;
    }

    public BigDecimal getLamda() {
        return lamda;
    }

    public void setLamda(BigDecimal lamda) {
        this.lamda = lamda;
    }
}