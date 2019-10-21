package com.advyteam.dsn.dto;

/**
 * Created by hboulahia on 20/10/19.
 */
public class Establisment {
    private String code;
    private String label;
    private String society;
    private int nic;
    private int siret;

    public Establisment(String code, String label, String society, int nic, int siret) {
        this.code = code;
        this.label = label;
        this.society = society;
        this.nic = nic;
        this.siret = siret;
    }

    public String getSociety() {
        return society;
    }

    public int getNic() {
        return nic;
    }

    public int getSiret() {
        return siret;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setSociety(String society) {
        this.society = society;
    }

    public void setNic(int nic) {
        this.nic = nic;
    }

    public void setSiret(int siret) {
        this.siret = siret;
    }
}
