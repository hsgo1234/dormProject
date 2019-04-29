package com.qddx.domain;

import java.io.Serializable;
import java.sql.Timestamp;

public class Visitors implements Serializable {
    private Integer visid;

    private String visname;

    private Integer vistel;

    private Byte state;

    private String reason;

    private String stuname;

    private Integer stuid;

    private Integer dormid;

    private Integer roomid;

    private Timestamp visdate;

    private String dormname;

    private static final long serialVersionUID = 1L;

    public Integer getVisid() {
        return visid;
    }

    public void setVisid(Integer visid) {
        this.visid = visid;
    }

    public String getVisname() {
        return visname;
    }

    public void setVisname(String visname) {
        this.visname = visname == null ? null : visname.trim();
    }

    public Integer getVistel() {
        return vistel;
    }

    public void setVistel(Integer vistel) {
        this.vistel = vistel;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname == null ? null : stuname.trim();
    }

    public Integer getStuid() {
        return stuid;
    }

    public void setStuid(Integer stuid) {
        this.stuid = stuid;
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

    public String getVisdate() {
        return visdate.toString();
    }

    public void setVisdate(Timestamp visdate) {
        this.visdate = visdate;
    }

    public String getDormname() {
        return dormname;
    }

    public void setDormname(String dormname) {
        this.dormname = dormname;
    }
}