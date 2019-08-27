package com.hunter.blog.modules.user.controller;

import com.alibaba.fastjson.JSON;
import com.hunter.blog.modules.user.model.UserDto;
import com.hunter.blog.modules.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author ChenLiang
 * @version 1.0.0
 * @description 用户前端控制类
 * @data: 2019/8/26 8:52
 */
@RestController
@RequestMapping("sys/user")
public class UserController {

    @Autowired
    private IUserService userService;

    /**
     * 用户登录
     *
     * @param userDto
     * @return
     */
    @RequestMapping("/login")
    public String login(UserDto userDto, Map<String, Object> map) {
        return JSON.toJSONString(userService.userLogin(userDto, map));
    }

}


















































