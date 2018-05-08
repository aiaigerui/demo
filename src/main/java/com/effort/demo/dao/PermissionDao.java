package com.effort.demo.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.effort.demo.common.MyBatisRepository;
import com.effort.demo.model.Permission;

@MyBatisRepository
public interface PermissionDao extends BaseMapper<Permission> {
}
