package com.user.entity;

import java.sql.*;
   /**
    * MPS 实体类
    * Sat Sep 21 11:44:09 CST 2019 ***
    */ 


public class MPS{
	private String mpsno;
	private String taskno;
	private String processfileno;
	private String manunumber;
	private String startdate;
	private String enddate;
	private String department;
	private String status;
	private String type;
	private String urgent;
	public void setMpsno(String mpsno){
	this.mpsno=mpsno;
	}
	public String getMpsno(){
		return mpsno;
	}
	public void setTaskno(String taskno){
	this.taskno=taskno;
	}
	public String getTaskno(){
		return taskno;
	}
	public void setProcessfileno(String processfileno){
	this.processfileno=processfileno;
	}
	public String getProcessfileno(){
		return processfileno;
	}
	public void setManunumber(String manunumber){
	this.manunumber=manunumber;
	}
	public String getManunumber(){
		return manunumber;
	}
	public void setStartdate(String startdate){
	this.startdate=startdate;
	}
	public String getStartdate(){
		return startdate;
	}
	public void setEnddate(String enddate){
	this.enddate=enddate;
	}
	public String getEnddate(){
		return enddate;
	}
	public void setDepartment(String department){
	this.department=department;
	}
	public String getDepartment(){
		return department;
	}
	public void setStatus(String status){
	this.status=status;
	}
	public String getStatus(){
		return status;
	}
	public void setType(String type){
	this.type=type;
	}
	public String getType(){
		return type;
	}
	public void setUrgent(String urgent){
	this.urgent=urgent;
	}
	public String getUrgent(){
		return urgent;
	}
}

