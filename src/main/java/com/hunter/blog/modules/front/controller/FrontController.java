package com.hunter.blog.modules.front.controller;

import com.alibaba.fastjson.JSON;
import com.hunter.blog.modules.front.service.IFrontService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public String index(Map<String, Object> map, Integer curPage, Integer pageSize) {
        System.out.println("\033[36;4m" + "index()方法执行了..." + "\033[0m");
        System.out.println(curPage + "," + pageSize);
        map.put("curPage",curPage);
        map.put("pageSize",pageSize);
        Map data = frontService.setHtml(map);
        return JSON.toJSONString(data);
    }
}
