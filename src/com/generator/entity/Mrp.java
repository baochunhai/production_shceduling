package com.generator.entity;

public class Mrp {
    private String 任务号;

    private Integer 投产数量;

    private String 计划开始日期;

    private String 交货期;

    public String get任务号() {
        return 任务号;
    }

    public void set任务号(String 任务号) {
        this.任务号 = 任务号;
    }

    public Integer get投产数量() {
        return 投产数量;
    }

    public void set投产数量(Integer 投产数量) {
        this.投产数量 = 投产数量;
    }

    public String get计划开始日期() {
        return 计划开始日期;
    }

    public void set计划开始日期(String 计划开始日期) {
        this.计划开始日期 = 计划开始日期;
    }

    public String get交货期() {
        return 交货期;
    }

    public void set交货期(String 交货期) {
        this.交货期 = 交货期;
    }
}