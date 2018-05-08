package com.effort.demo.model;

import com.baomidou.mybatisplus.annotations.TableName;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

@TableName("ef_role_permission")
@Transactional
public class RolePermission implements Serializable {
    private Long id;
    private Long roleId;
    private Long permissionId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }
}
