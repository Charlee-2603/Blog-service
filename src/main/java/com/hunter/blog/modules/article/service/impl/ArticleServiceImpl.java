package com.hunter.blog.modules.article.service.impl;

import com.hunter.blog.modules.article.dao.IArticleDao;
import com.hunter.blog.modules.article.model.ArticleDo;
import com.hunter.blog.modules.article.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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

//    @Override
//    public List<ArticleDo> getArticleList(String condition) {
//        return articleDao.getArticleList(condition,);
//    }

    @Override
    public void saveArticle(ArticleDo articleDo) {
        articleDao.saveArticle(articleDo);
    }

    @Override
    public ArticleDo getArticleById(int artId, Map<String, Object> map) {

        ArticleDo article = articleDao.getArticleById(artId);

        // 更新浏览次数
        articleDao.updateClickCount(artId);

        String articleCreateTime = article.getArtCreateTime();
        System.out.println(articleCreateTime);
        if (articleCreateTime != null && !"".equals(articleCreateTime)) {
            // 根据文章Id查询上一篇文章id
            Integer prvArtId = articleDao.getPrvArticleByCreateTime(articleCreateTime);
            System.out.println("上一篇文章id:" + prvArtId);
            if (prvArtId == null){
                prvArtId = 0;
            }
            // 根据文章Id查询下一篇文章id
            Integer nextArtId = articleDao.getNextArticleByCreateTime(articleCreateTime);
            System.out.println("下一篇文章id:" + nextArtId);
            if (nextArtId == null){
                nextArtId = 0;
            }
            map.put("prvArtId", prvArtId);
            map.put("nextArtId", nextArtId);
        }
        return article;
    }
}
