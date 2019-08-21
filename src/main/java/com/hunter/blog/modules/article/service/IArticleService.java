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

//    /**
//     * 根据搜索内容返回文章列表
//     *
//     * @param condition
//     * @return
//     */
//    List<ArticleDo> getArticleList(String condition);

    /**
     * 发布文章
     *
     * @param articleDo
     */
    void saveArticle(ArticleDo articleDo);

    /**
     * 根据文章Id获取该文章的详情
     * @param artId
     * @return
     */
    ArticleDo getArticleById(int artId);

}
