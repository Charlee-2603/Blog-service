package com.hunter.blog.modules.front.service.impl;

import com.hunter.blog.modules.front.dao.IFrontDao;
import com.hunter.blog.modules.front.model.FrontDo;
import com.hunter.blog.modules.front.service.IFrontService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ChenLiang
 * @version 1.0.0
 * @description 首页service接口实现类
 * @time 2019/8/13 14:09
 */
@Service
public class FrontServiceImpl implements IFrontService {

    @Autowired
    private IFrontDao frontDao;

    @Override
    public Map setHtml() {
        /**
         * 获取博客的信息
         */
        Map<Object, Object> map = new HashMap<>();
        List<FrontDo> blogArticle = frontDao.getSysConfig("blogArticle");
        map.put("front", blogArticle);
        return map;
    }
}
