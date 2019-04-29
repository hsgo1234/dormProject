package com.qddx.domain;

import java.io.Serializable;
import java.sql.Timestamp;

public class BedTime implements Serializable {
    private Integer stuid;

    private String stuname;

    private String bedtype;

    private Timestamp beddate;

    private Integer dormid;

    private Integer roomid;

    private String dormname;

    private static final long serialVersionUID = 1L;

    public Integer getStuid() {
        return stuid;
    }

    public void setStuid(Integer stuid) {
        this.stuid = stuid;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public String getBedtype() {
        return bedtype;
    }

    public void setBedtype(String bedtype) {
        this.bedtype = bedtype == null ? null : bedtype.trim();
    }

    public String getBeddate() {
        return beddate.toString();
    }

    public void setBeddate(Timestamp beddate) {
        this.beddate = beddate;
    }

    public Integer getDormid() {
        return dormid;
    }

    public void setDormid(Integer dormid) {
        this.dormid = dormid;
    }

    public Integer getRoomid() {
        return roomid;
    }

    public void setRoomid(Integer roomid) {
        this.roomid = roomid;
    }

    public String getDormname() {
        return dormname;
    }

    public void setDormname(String dormname) {
        this.dormname = dormname;
    }
}