package com.qddx.domain;

import java.io.Serializable;

public class Teacher implements Serializable {
    private Integer teaid;

    private String teaname;

    private Integer teatel;

    private String teamail;

    private Integer teagrade;

    private static final long serialVersionUID = 1L;

    public Integer getTeaid() {
        return teaid;
    }

    public void setTeaid(Integer teaid) {
        this.teaid = teaid;
    }

    public String getTeaname() {
        return teaname;
    }

    public void setTeaname(String teaname) {
        this.teaname = teaname == null ? null : teaname.trim();
    }

    public Integer getTeatel() {
        return teatel;
    }

    public void setTeatel(Integer teatel) {
        this.teatel = teatel;
    }

    public String getTeamail() {
        return teamail;
    }

    public void setTeamail(String teamail) {
        this.teamail = teamail == null ? null : teamail.trim();
    }

    public Integer getTeagrade() {
        return teagrade;
    }

    public void setTeagrade(Integer teagrade) {
        this.teagrade = teagrade;
    }
}