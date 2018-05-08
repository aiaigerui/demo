package com.effort.demo.model;

import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

@TableName("ef_permission")
public class Permission implements Serializable {
    private Long id;
    private String permissionName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }
}
