package com.effort.demo.model;

import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

@TableName("ef_role")
public class Role implements Serializable {
    private Long id;
    private String roleName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
