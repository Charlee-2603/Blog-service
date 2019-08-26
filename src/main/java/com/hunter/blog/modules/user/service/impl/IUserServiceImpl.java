package com.hunter.blog.modules.user.service.impl;

import com.hunter.blog.modules.user.dao.IUserDao;
import com.hunter.blog.modules.user.model.UserDo;
import com.hunter.blog.modules.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author ChenLiang
 * @version 1.0.0
 * @description 用户service接口实现类
 * @data: 2019/8/26 9:00
 */
@Service
public class IUserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;


    @Override
    public int userLogin(UserDo userDo) {
        return userDao.userLogin(userDo);
    }
}
