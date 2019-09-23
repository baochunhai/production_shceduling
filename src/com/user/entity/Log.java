package com.user.entity;

import java.util.Date;
   /**
    * log 实体类
    * Mon Sep 23 08:35:57 CST 2019 ***
    */ 


public class Log{
	private Long id;
	private String operateor;
	private String operatetype;
	private Date operatedate;
	private String operateresult;
	private String ip;
	public void setId(Long id){
	this.id=id;
	}
	public Long getId(){
		return id;
	}
	public void setOperateor(String operateor){
	this.operateor=operateor;
	}
	public String getOperateor(){
		return operateor;
	}
	public void setOperatetype(String operatetype){
	this.operatetype=operatetype;
	}
	public String getOperatetype(){
		return operatetype;
	}
	public void setOperatedate(Date operatedate){
	this.operatedate=operatedate;
	}
	public Date getOperatedate(){
		return operatedate;
	}
	public void setOperateresult(String operateresult){
	this.operateresult=operateresult;
	}
	public String getOperateresult(){
		return operateresult;
	}
	public void setIp(String ip){
	this.ip=ip;
	}
	public String getIp(){
		return ip;
	}
}

