package com.hunter.blog.modules.article.dao;

import com.hunter.blog.modules.article.model.ArticleDo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ChenLiang
 * @version 1.0.0
 * @description 文章持久层接口
 * @data: 2019/8/14 9:18
 */
@Mapper
@Repository
public interface IArticleDao {
    /**
     * 获取文章列表
     * @param condition
     * @return
     */
    List<ArticleDo> getArticle(String condition);
}
