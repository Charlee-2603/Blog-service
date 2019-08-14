package com.hunter.blog.modules.article.service.impl;

import com.hunter.blog.modules.article.dao.IArticleDao;
import com.hunter.blog.modules.article.model.ArticleDo;
import com.hunter.blog.modules.article.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ChenLiang
 * @version 1.0.0
 * @description 文章service实现类
 * @data: 2019/8/14 9:40
 */
@Service
public class ArticleServiceImpl implements IArticleService {

    @Autowired
    private IArticleDao articleDao;

    @Override
    public List<ArticleDo> getArticle(String condition) {
        return articleDao.getArticle(condition);
    }
}
