package com.hunter.blog.modules.user.service.impl;

import com.alibaba.fastjson.JSON;
import com.hunter.blog.modules.user.dao.IUserDao;
import com.hunter.blog.modules.user.model.UserDo;
import com.hunter.blog.modules.user.model.UserDto;
import com.hunter.blog.modules.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.Map;


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
    public Map userLogin(UserDto userDto, Map<String, Object> map) {
        // 获取前端传过来的sessionId
        String sessionId = userDto.getSessionId();
        // 获取前端传过来的验证码
        String code = userDto.getCode();

        if (sessionId != null || !sessionId.equals("")) {
            Jedis jedis = new Jedis();
            String sid = jedis.get(userDto.getSessionId());
            if (sid != null || !sid.equals("")) {
                if (sid.toUpperCase().equals(code.toUpperCase())) {
                    // 判断账号密码是否正确
                    int res = userDao.userLogin(userDto);
                    if (res == 0) {
                        // 登录失败
                        map.put("type", "error");
                        map.put("msg", "账号或密码错误");
                        return map;
                    } else if (res == 1) {
                        // 登录成功
                        map.put("type", "success");
                        map.put("msg", "登录成功");
                        return map;
                    }
                } else {
                    map.put("type", "error");
                    map.put("msg", "验证码错误");
                    return map;
                }
            }
        }
        map.put("type", "error");
        map.put("msg", "系统异常");
        return map;
    }
}
