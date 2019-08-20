package com.hunter.blog.modules.article.controller;

import com.alibaba.fastjson.JSON;
import com.hunter.blog.modules.article.model.ArticleDo;
import com.hunter.blog.modules.article.service.IArticleService;
import com.hunter.blog.modules.article.utils.UpFileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.System.out;

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
     * 通过搜索内容查找文章
     *
     * @param condition
     * @return
     */
    @RequestMapping(value = "/getArticleByCondition", method = RequestMethod.POST)
    public String getArticleByCondition(@RequestParam(value = "condition", required = false) String condition) {
        out.println("\033[36;4m" + "getArticleByCondition()方法执行了..." + "\033[0m");
        out.println(condition);

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
    public String postArticle(@ModelAttribute ArticleDo articleDo, @RequestParam("articleFile") MultipartFile articleFile, HttpServletRequest request) {
        out.println("\033[22;4m" + "postArticle()方法执行了..." + "\033[0m");
        if (!articleFile.isEmpty()) {
            try {
                String artTitleImgURL = UpFileUtil.setUpFileName(articleFile.getOriginalFilename(), articleFile, request);

                articleDo.setArtCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                articleDo.setArtTitleImgURL(artTitleImgURL);
                articleService.saveArticle(articleDo);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return "上传失败," + e.getMessage();
            } catch (IOException e) {
                e.printStackTrace();
                return "上传失败" + e.getMessage();
            }
            return "上传成功";
        } else {
            return "上传失败，因为文件是空的.";
        }
    }
}
