package com.qddx.domain;

import java.io.Serializable;

public class Student implements Serializable {
    private Integer stuid;

    private Integer stueyear;

    private Integer roomid;

    private Integer dormid;

    private String stuname;

    private Integer stutel;

    private String stumail;

    private String stusex;

    private String stuins;

    private String studep;

    private String stuclass;

    private static final long serialVersionUID = 1L;

    public Integer getStuid() {
        return stuid;
    }

    public void setStuid(Integer stuid) {
        this.stuid = stuid;
    }

    public Integer getStueyear() {
        return stueyear;
    }

    public void setStueyear(Integer stueyear) {
        this.stueyear = stueyear;
    }

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

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname == null ? null : stuname.trim();
    }

    public Integer getStutel() {
        return stutel;
    }

    public void setStutel(Integer stutel) {
        this.stutel = stutel;
    }

    public String getStumail() {
        return stumail;
    }

    public void setStumail(String stumail) {
        this.stumail = stumail == null ? null : stumail.trim();
    }

    public String getStusex() {
        return stusex;
    }

    public void setStusex(String stusex) {
        this.stusex = stusex == null ? null : stusex.trim();
    }

    public String getStuins() {
        return stuins;
    }

    public void setStuins(String stuins) {
        this.stuins = stuins == null ? null : stuins.trim();
    }

    public String getStudep() {
        return studep;
    }

    public void setStudep(String studep) {
        this.studep = studep == null ? null : studep.trim();
    }

    public String getStuclass() {
        return stuclass;
    }

    public void setStuclass(String stuclass) {
        this.stuclass = stuclass == null ? null : stuclass.trim();
    }
}