package com.hunter.blog.modules.front.controller;

import com.hunter.blog.modules.front.service.IFrontService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ChenLiang
 * @version 1.0.0
 * @description 首页控制类
 * @time 2019/8/12 18:34
 */
@RestController
@RequestMapping("/sys/front")
public class FrontController {

    @Autowired
    private IFrontService frontService;

    @CrossOrigin
    @RequestMapping("/index")
    public Map<String, Object> index() {
        System.out.println("\033[36;4m" + "index()方法执行了..." + "\033[0m");
        Map map = frontService.setHtml();
        return map;
    }
}
