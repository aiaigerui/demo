package com.effort.demo.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.effort.demo.dao.RolePermissionDao;
import com.effort.demo.model.RolePermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RolePermissionService {

    @Autowired
    private RolePermissionDao rolePermissionDao;

    public List<RolePermission> getByRoleId(Long roleId) {
        Wrapper wrapper = new EntityWrapper<RolePermission>();
        wrapper.eq("role_id", roleId);
        return rolePermissionDao.selectList(wrapper);
    }
    
}
