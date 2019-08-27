package com.hunter.blog.modules.user.service;

import com.hunter.blog.modules.user.model.UserDto;

import java.util.Map;

/**
 * @author ChenLiang
 * @version 1.0.0
 * @description 用户service接口类
 * @data: 2019/8/26 8:58
 */
public interface IUserService {

    /**
     * 用户登录
     * @param userDto
     * @param map
     * @return
     */
    Map userLogin(UserDto userDto, Map<String, Object> map);
}
