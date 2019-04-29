package com.qddx.domain;

import java.io.Serializable;

public class Room implements Serializable {
    private Integer roomid;

    private Integer dormid;

    private Integer roomno;

    private String dormname;

    private Integer roomfloor;

    private Integer roomcap;

    private String roomocc;

    private String roomname;

    private static final long serialVersionUID = 1L;

    public Integer getRoomid() {
        return roomid;
    }

    public void setRoomid(Integer roomid) {
        this.roomid = roomid;
    }

    public Integer getDormid() {
        return dormid;
    }

    public void setDormid(Integer dormid) {
        this.dormid = dormid;
    }

    public Integer getRoomno() {
        return roomno;
    }

    public void setRoomno(Integer roomno) {
        this.roomno = roomno;
    }

    public String getDormname() { return dormname; }

    public void setDormname(String dormname) { this.dormname = dormname; }

    public Integer getRoomfloor() {
        return roomfloor;
    }

    public void setRoomfloor(Integer roomfloor) {
        this.roomfloor = roomfloor;
    }

    public Integer getRoomcap() {
        return roomcap;
    }

    public void setRoomcap(Integer roomcap) {
        this.roomcap = roomcap;
    }

    public String getRoomocc() {
        return roomocc;
    }

    public void setRoomocc(String roomocc) {
        this.roomocc = roomocc == null ? null : roomocc.trim();
    }

    public String getRoomname() {
        return roomname;
    }

    public void setRoomname(String roomname) {
        this.roomname = roomname == null ? null : roomname.trim();
    }
}