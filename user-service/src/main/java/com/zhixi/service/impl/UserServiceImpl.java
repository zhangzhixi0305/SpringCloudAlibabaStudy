package com.zhixi.service.impl;

import com.zhixi.mapper.UserMapper;
import com.zhixi.pojo.User;
import com.zhixi.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName UserServiceImpl
 * @Author zhangzhixi
 * @Description
 * @Date 2022-5-29 18:43
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper mapper;

    @Override
    public User getUserById(int uid) {
        return mapper.getUserById(uid);
    }


    @Override
    public int getRemain(int uid) {
        return mapper.getUserBookRemain(uid);
    }

    @Override
    public boolean setRemain(int uid, int count) {
        return mapper.updateBookCount(uid, count) > 0;
    }

    @Override
    public int updateUser(int uid, int bookCount) {
        return mapper.updateUser(uid, bookCount);
    }
}
