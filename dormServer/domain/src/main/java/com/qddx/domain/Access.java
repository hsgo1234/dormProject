package com.qddx.domain;

import java.io.Serializable;
import java.sql.Timestamp;

public class Access implements Serializable {
    private Integer stuid;

    private String stuname;

    private String acctype;

    private Timestamp accdate;

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

    public String getAcctype() {
        return acctype;
    }

    public void setAcctype(String acctype) {
        this.acctype = acctype == null ? null : acctype.trim();
    }

    public String getAccdate() {
        return accdate.toString();
    }

    public void setAccdate(Timestamp accdate) {
        this.accdate = accdate;
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