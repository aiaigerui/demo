package com.effort.demo.service;

import com.effort.demo.dao.RoleDao;
import com.effort.demo.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleService {

    @Autowired
    private RoleDao roleDao;

    public List<Role> findBatchIds(List<Long> ids) {
        return roleDao.selectBatchIds(ids);
    }
}
