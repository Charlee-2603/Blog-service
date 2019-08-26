package com.hunter.blog.modules.user.controller;

import com.alibaba.fastjson.JSON;
import com.hunter.blog.modules.user.model.UserDo;
import com.hunter.blog.modules.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
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
     * @param userDo
     * @return
     */
    @RequestMapping("login")
    public String login(UserDo userDo) {
        int res = userService.userLogin(userDo);
        Map<String, Object> map = new HashMap<>(16);
        if (res == 0) {
            // 登录失败
            map.put("type", "error");
            map.put("msg", "登录失败");
            return JSON.toJSONString(map);
        }else if (res == 1){
            // 登录成功
            map.put("type", "success");
            map.put("msg", "登录成功");
            return JSON.toJSONString(map);
        }
        map.put("type", "error");
        map.put("msg", "系统异常");
        return JSON.toJSONString(map);
    }

}
