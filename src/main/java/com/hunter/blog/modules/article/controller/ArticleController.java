package com.hunter.blog.modules.article.controller;

import com.alibaba.fastjson.JSON;
import com.hunter.blog.modules.article.model.ArticleDo;
import com.hunter.blog.modules.article.service.IArticleService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/getArticleByCondition", method = RequestMethod.GET)
    public String getArticleByCondition(@RequestParam(value = "condition", required = false) String condition) {
        System.out.println("\033[36;4m" + "getArticleByCondition()方法执行了..." + "\033[0m");
        System.out.println(condition);

        Map<String, Object> data = new HashMap<>(10);
        List<ArticleDo> articleList = articleService.getArticle(condition);
        data.put("articleList", articleList);
        return JSON.toJSONString(articleList);
    }
}
