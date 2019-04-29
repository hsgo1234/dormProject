package com.qddx.domain;

import java.io.Serializable;

public class Dormitory implements Serializable {
    private Integer dormid;

    private String dormname;

    private Integer dormno;

    private String dormaddr;

    private Integer dormcap;

    private Integer olddormid;

    private static final long serialVersionUID = 1L;

    public Integer getDormid() {
        return dormid;
    }

    public void setDormid(Integer dormid) {
        this.dormid = dormid;
    }

    public String getDormname() {
        return dormname;
    }

    public void setDormname(String dormname) {
        this.dormname = dormname == null ? null : dormname.trim();
    }

    public Integer getDormno() {
        return dormno;
    }

    public void setDormno(Integer dormno) {
        this.dormno = dormno;
    }

    public String getDormaddr() {
        return dormaddr;
    }

    public void setDormaddr(String dormaddr) {
        this.dormaddr = dormaddr == null ? null : dormaddr.trim();
    }

    public Integer getDormcap() {
        return dormcap;
    }

    public void setDormcap(Integer dormcap) {
        this.dormcap = dormcap;
    }

    public Integer getOlddormid() {
        return olddormid;
    }

    public void setOlddormid(Integer olddormid) {
        this.olddormid = olddormid;
    }
}