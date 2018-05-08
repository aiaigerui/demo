package com.effort.demo.model;

import com.baomidou.mybatisplus.annotations.TableName;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

@TableName("ef_user_role")
@Transactional
public class UserRole implements Serializable {
    private Long id;
    private Long userId;
    private Long roleId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
