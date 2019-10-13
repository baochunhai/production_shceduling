package cn.lastwhisper.product.pojo;

import java.math.BigDecimal;

public class Gaschedule {
    private String mpsno;

    private String processno;

    private String machineno;

    private Integer partno;

    private Integer proctime;

    private String starttime;

    private String endtime;

    private String status;

    public String getMpsno() {
        return mpsno;
    }

    public void setMpsno(String mpsno) {
        this.mpsno = mpsno;
    }

    public String getProcessno() {
        return processno;
    }

    public void setProcessno(String processno) {
        this.processno = processno;
    }

    public String getMachineno() {
        return machineno;
    }

    public void setMachineno(String machineno) {
        this.machineno = machineno;
    }

    public Integer getPartno() {
        return partno;
    }

    public void setPartno(Integer partno) {
        this.partno = partno;
    }

    public Integer getProctime() {
        return proctime;
    }

    public void setProctime(Integer proctime) {
        this.proctime = proctime;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}