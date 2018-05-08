package com.effort.demo.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.effort.demo.common.MyBatisRepository;
import com.effort.demo.model.User;

@MyBatisRepository
public interface UserDao extends BaseMapper<User> {
}
