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
        // 每页显示多少条记录
        Integer pageSize = (Integer) map.get("pageSize");
        // 当前第几页
        Integer curPage = (Integer) map.get("curPage");
        // 当前第几条
        Integer pageNum = (curPage - 1) * pageSize;

        System.out.println("当前页：" + pageNum + "," + pageSize);

        // 查询总文章数
        int total = articleDao.getArticleCount();
        System.out.println(total);
        int pageTotal = 0;

        if (total % pageSize == 0) {
            pageTotal = total / pageSize;
        } else {
            pageTotal = (total / pageSize) + 1;
        }
        System.out.println("pageTotal:" + pageTotal);

        if (curPage > 0 && curPage < pageTotal) {
            map.put("articleList", articleDao.getArticleList(condition, pageNum, pageSize));
        } else if (curPage <= 0) {
            map.put("articleList", articleDao.getArticleList(condition, 0, pageSize));
        } else {
            map.put("articleList", articleDao.getArticleList(condition, (pageTotal - 1) * pageSize, pageSize));
        }
        return map;
    }
}
