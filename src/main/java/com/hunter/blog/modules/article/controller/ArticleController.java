package com.hunter.blog.modules.article.controller;

import com.alibaba.fastjson.JSON;
import com.hunter.blog.modules.article.model.ArticleDo;
import com.hunter.blog.modules.article.service.IArticleService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ChenLiang
 * @version 1.0.0
 * @description
 * @time 2019/8/14 9:37
 */
@RestController
@CrossOrigin
@RequestMapping("/sys/article")
public class ArticleController {

    @Autowired
    private IArticleService articleService;

    /**
     * 文章标题图片上传
     * @return
     */
    @RequestMapping(value = "/articleTitleImg",method = RequestMethod.POST)
    public String articleTitleImg() {
        System.out.println("\033[36;4m" + "articleTitleImg()方法执行了..." + "\033[0m");
        return "";
    }

    /**
     * 通过搜索内容查找文章
     *
     * @param condition
     * @return
     */
    @RequestMapping(value = "/getArticleByCondition", method = RequestMethod.POST)
    public String getArticleByCondition(@RequestParam(value = "condition", required = false) String condition) {
        System.out.println("\033[36;4m" + "getArticleByCondition()方法执行了..." + "\033[0m");
        System.out.println(condition);

        Map<String, Object> data = new HashMap<>(10);
        List<ArticleDo> articleList = articleService.getArticle(condition);
        data.put("articleList", articleList);
        return JSON.toJSONString(articleList);
    }

    /**
     * 发布文章
     *
     * @param articleDo
     * @return
     */
    @RequestMapping(value = "/postArticle", method = RequestMethod.POST)
    public String postArticle(@ModelAttribute ArticleDo articleDo) {
        System.out.println("\033[22;4m" + "postArticle()方法执行了..." + "\033[0m");
        System.out.println(articleDo);

        articleDo.setArtCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        articleService.saveArticle(articleDo);

        return "success";
    }

}
