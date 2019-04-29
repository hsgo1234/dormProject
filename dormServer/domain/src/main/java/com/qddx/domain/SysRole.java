package com.qddx.domain;

import java.io.Serializable;
import java.util.List;

/**
 * @Description: 角色实体类
 * @Author: HUOHENGTONG
 * @CreateDate: 2019/4/16 13:08
 */
public class SysRole implements Serializable {
    public static final long serialVersionUID = 1L;

    private Long id;
    private String role;
    private String description;
    private Boolean available = Boolean.FALSE;//是否可用，如果不可用将不会添加给用户。

    private List<SysPermission> permissions;//一个角色拥有多个权限
    private List<UserInfo> userInfos;//一个角色被多个用户拥有

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public List<SysPermission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<SysPermission> permissions) {
        this.permissions = permissions;
    }

    public List<UserInfo> getUserInfos() {
        return userInfos;
    }

    public void setUserInfos(List<UserInfo> userInfos) {
        this.userInfos = userInfos;
    }

    @Override
    public String toString() {
        return "SysRole{" +
                "id=" + id +
                ", role='" + role + '\'' +
                ", description='" + description + '\'' +
                ", available=" + available +
                ", permissions=" + permissions +
                ", userInfos=" + userInfos +
                '}';
    }
}
