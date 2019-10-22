package com.advyteam.dsn.dto;

/**
 * Created by hboulahia on 20/10/19.
 */
public class DsnFile {

    private String key;
    private String value;

    public DsnFile() {
    }

    public DsnFile(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }


    public void setKey(String key) {
        this.key = key;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "DsnFile{" +
            "key='" + key + '\'' +
            ", value='" + value + '\'' +
            '}';
    }
}
