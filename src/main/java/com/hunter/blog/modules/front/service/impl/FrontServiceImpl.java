package com.hunter.blog.modules.front.service.impl;

import com.hunter.blog.modules.article.dao.IArticleDao;
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
    @Autowired
    private IArticleDao articleDao;

    @Override
    public Map<String, Object> setHtml(Map<String, Object> map) {
        /**
         * 获取首页基础信息
         */
        map.put("baseInfo", frontDao.getSysConfig("baseInfo"));
        /**
         * 获取首页栏目列表
         */
        map.put("columnList", frontDao.getSysConfig("columnList"));
        /**
         * 获取首页栏目按钮
         */
        map.put("columnBtn", frontDao.getSysConfig("columnBtn"));

        /**
         * 获取首页文章
         */
        String condition = "";
        map.put("articleList", articleDao.getArticle(""));
        return map;
    }
}
