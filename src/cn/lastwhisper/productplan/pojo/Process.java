package cn.lastwhisper.productplan.pojo;

public class Process {
    private String mpsno;

    private String processno;

    private String sequenceno;

    private String machineno;

    private String scheduledstarttime;

    private String scheduledendtime;

    private String actualstarttime;

    private String actualendtime;

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

    public String getSequenceno() {
        return sequenceno;
    }

    public void setSequenceno(String sequenceno) {
        this.sequenceno = sequenceno;
    }

    public String getMachineno() {
        return machineno;
    }

    public void setMachineno(String machineno) {
        this.machineno = machineno;
    }

    public String getScheduledstarttime() {
        return scheduledstarttime;
    }

    public void setScheduledstarttime(String scheduledstarttime) {
        this.scheduledstarttime = scheduledstarttime;
    }

    public String getScheduledendtime() {
        return scheduledendtime;
    }

    public void setScheduledendtime(String scheduledendtime) {
        this.scheduledendtime = scheduledendtime;
    }

    public String getActualstarttime() {
        return actualstarttime;
    }

    public void setActualstarttime(String actualstarttime) {
        this.actualstarttime = actualstarttime;
    }

    public String getActualendtime() {
        return actualendtime;
    }

    public void setActualendtime(String actualendtime) {
        this.actualendtime = actualendtime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}