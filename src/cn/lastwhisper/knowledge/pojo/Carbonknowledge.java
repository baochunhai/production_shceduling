package cn.lastwhisper.knowledge.pojo;

import java.io.Serializable;

public class Carbonknowledge implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String processno;

    private String type;

    private String processname;

    private String processtype;

    private String stationname;

    private String knowledge;

    public String getProcessno() {
        return processno;
    }

    public void setProcessno(String processno) {
        this.processno = processno;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(String knowledge) {
        this.knowledge = knowledge;
    }
}