package com.advyteam.dsn.dto.retour;

/**
 * Created by hboulahia on 22/10/19.
 */
public class GeneratedDsn {

    private String Perpai;
    private String Society;
    private String establisment;

    public GeneratedDsn(String perpai, String society, String establisment) {
        Perpai = perpai;
        Society = society;
        this.establisment = establisment;
    }

    public GeneratedDsn() {
    }

    public String getPerpai() {
        return Perpai;
    }

    public String getSociety() {
        return Society;
    }

    public String getEstablisment() {
        return establisment;
    }

    public void setPerpai(String perpai) {
        Perpai = perpai;
    }

    public void setSociety(String society) {
        Society = society;
    }

    public void setEstablisment(String establisment) {
        this.establisment = establisment;
    }
}
