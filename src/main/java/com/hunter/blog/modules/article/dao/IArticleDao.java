package com.hunter.blog.modules.article.dao;

import com.hunter.blog.modules.article.model.ArticleDo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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
     *
     * @param condition
     * @param curPage
     * @param pageSize
     * @return
     */
    List<ArticleDo> getArticleList(@Param("condition") String condition, @Param("curPage") Integer curPage, @Param("pageSize") Integer pageSize);

    /**
     * 发布文章
     *
     * @param articleDo
     */
    void saveArticle(@Param("articleDo") ArticleDo articleDo);

    /**
     * 根据文章ID获取文章的详细信息
     *
     * @param artId
     * @return
     */
    ArticleDo getArticleById(@Param("artId") int artId);

    /**
     * 点击量 + 1
     *
     * @param artId
     * @return
     */
    void updateClickCount(int artId);


    /**
     * 查询文章总数
     *
     * @return
     */
    int getArticleCount();

    /**
     * 下一篇文章的Id
     *
     * @param articleCreateTime
     * @return
     */
    Integer getNextArticleByCreateTime(@Param("articleCreateTime") String articleCreateTime);

    /**
     * 上一篇文章的id
     *
     * @param articleCreateTime
     * @return
     */
    Integer getPrvArticleByCreateTime(@Param("articleCreateTime") String articleCreateTime);
}
