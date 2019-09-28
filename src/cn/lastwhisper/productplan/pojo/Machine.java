package cn.lastwhisper.productplan.pojo;

import java.math.BigDecimal;

public class Machine {
    private String machineno;

    private BigDecimal id;

    private String machinename;

    private String coefficiency;

    public String getMachineno() {
        return machineno;
    }

    public void setMachineno(String machineno) {
        this.machineno = machineno;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getMachinename() {
        return machinename;
    }

    public void setMachinename(String machinename) {
        this.machinename = machinename;
    }

    public String getCoefficiency() {
        return coefficiency;
    }

    public void setCoefficiency(String coefficiency) {
        this.coefficiency = coefficiency;
    }
}