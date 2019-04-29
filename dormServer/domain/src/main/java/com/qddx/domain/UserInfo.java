package com.qddx.domain;

import java.io.Serializable;
import java.util.List;

/**
 * @Description: 用户信息
 * @Author: HUOHENGTONG
 * @CreateDate: 2019/4/16 12:58
 */
public class UserInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    private long uid;
    private String username;//账号
    private String name;//昵称
    private String password;
    private String salt;//加密密码的盐
    private byte state;//用户状态,0:创建未认证，等待（验证码）的用户。1：正常状态。2：用户被锁定。

    private List<SysRole> roleList;

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public byte getState() {
        return state;
    }

    public void setState(byte state) {
        this.state = state;
    }

    public List<SysRole> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<SysRole> roleList) {
        this.roleList = roleList;
    }

    /**
    * 重定义盐
    *
    * @params
    * @return
    */
    public String getCredentialsSalt(){
        return this.username+this.salt;
    }
    @Override
    public String toString() {
        return "UserInfo{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", state=" + state +
                ", roleList=" + roleList +
                '}';
    }
}
