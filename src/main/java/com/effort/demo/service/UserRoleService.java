package com.effort.demo.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.effort.demo.dao.UserRoleDao;
import com.effort.demo.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserRoleService {

    @Autowired
    private UserRoleDao userRoleDao;

    public List<UserRole> findByUserId(Long userId) {
        Wrapper wrapper = new EntityWrapper<UserRole>();
        wrapper.eq("user_id", userId);
        return userRoleDao.selectList(wrapper);
    }
}
