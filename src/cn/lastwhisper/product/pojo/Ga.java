package cn.lastwhisper.product.pojo;

import java.math.BigDecimal;

public class Ga {
    private BigDecimal partno;

    private String processno;

    private String machineno;

    private int proctime;

    private String starttime;

    private String endtime;

    private String status;

    private String mpsno;

    public BigDecimal getPartno() {
        return partno;
    }

    public void setPartno(BigDecimal partno) {
        this.partno = partno;
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

    public int getProctime() {
        return proctime;
    }

    public void setProctime(int proctime) {
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

    public String getMpsno() {
        return mpsno;
    }

    public void setMpsno(String mpsno) {
        this.mpsno = mpsno;
    }
}