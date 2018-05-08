package com.effort.demo.service;

import com.effort.demo.dao.PermissionDao;
import com.effort.demo.model.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PermissionService {

    @Autowired
    private PermissionDao permissionService;

    public Permission selectById(Long id) {
        return permissionService.selectById(id);
    }

}
