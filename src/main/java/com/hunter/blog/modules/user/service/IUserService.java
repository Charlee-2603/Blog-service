package com.hunter.blog.modules.user.service;

import com.hunter.blog.modules.user.model.UserDo;

/**
 * @description 用户service接口类
 * @author ChenLiang
 * @data: 2019/8/26 8:58
 * @version 1.0.0
 */
public interface IUserService {

    /**
     * 用户登录（判断用户是否存在）
     * @param userDo
     * @return
     */
    int userLogin(UserDo userDo);
}
