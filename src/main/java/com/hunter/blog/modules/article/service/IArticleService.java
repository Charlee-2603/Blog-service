package com.hunter.blog.modules.article.service;

import com.hunter.blog.modules.article.model.ArticleDo;

import java.util.List;

/**
 * @author ChenLiang
 * @version 1.0.0
 * @description 文章service接口
 * @data: 2019/8/14 9:38
 */

public interface IArticleService {

    /**
     * 根据搜索内容返回文章列表
     * @param condition
     * @return
     */
    List<ArticleDo> getArticle(String condition);

}
