package cn.lastwhisper.productplan.pojo;

import java.io.Serializable;

import oracle.sql.CLOB;

public class Carbonknowledge implements Serializable{
    private String processno;

    private String processname;

    private String processtype;

    private String stationname;
    
    private CLOB knowledge;

    public CLOB getKnowledge() {
		return knowledge;
	}

	public void setKnowledge(CLOB knowledge) {
		this.knowledge = knowledge;
	}

	public String getProcessno() {
        return processno;
    }

    public void setProcessno(String processno) {
        this.processno = processno;
    }

    public String getProcessname() {
        return processname;
    }

    public void setProcessname(String processname) {
        this.processname = processname;
    }

    public String getProcesstype() {
        return processtype;
    }

    public void setProcesstype(String processtype) {
        this.processtype = processtype;
    }

    public String getStationname() {
        return stationname;
    }

    public void setStationname(String stationname) {
        this.stationname = stationname;
    }
}