package com.effort.demo.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.effort.demo.common.MyBatisRepository;
import com.effort.demo.model.Role;

@MyBatisRepository
public interface RoleDao extends BaseMapper<Role> {
}
