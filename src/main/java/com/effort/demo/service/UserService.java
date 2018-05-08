package com.effort.demo.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.effort.demo.dao.UserDao;
import com.effort.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserDao userDao;

    public User getUserByUserName(String userName) {
        User user = new User();
        user.setUserName(userName);
        return userDao.selectOne(user);
    }

    public Page<User> findByPage(Page<User> page) {
        Wrapper wrapper = new EntityWrapper<>();
        List<User> users = userDao.selectPage(page, wrapper);
        page.setRecords(users);
        return page;
    }

    @Cacheable(value = "getAllUser", keyGenerator = "customKeyGenerator")
    public List<User> getAllUser() {
        Wrapper<User> wrapper = new EntityWrapper();
        return userDao.selectList(wrapper);
    }

    @CacheEvict(value = {"getAllUser", "getUserById", "findUsers"}, keyGenerator = "customKeyGenerator",
            allEntries = true)
    public int insertUser(User user) {
        return userDao.insert(user);
    }

    @CacheEvict(value = {"getAllUser", "getUserById", "findUsers"}, keyGenerator = "customKeyGenerator",
            allEntries = true)
    public int deleteUser(Long id) {
        return userDao.deleteById(id);
    }

    @Cacheable("findUsers")
    public List<User> findUsers(String keyWords) {
        Wrapper wrapper = new EntityWrapper();
        return userDao.selectList(wrapper);
    }

    @CacheEvict(value = {"getAllUser", "getUserById", "findUsers"}, keyGenerator = "customKeyGenerator",
            allEntries = true)
    public int updateUser(User user) {
        return userDao.updateById(user);
    }
}
