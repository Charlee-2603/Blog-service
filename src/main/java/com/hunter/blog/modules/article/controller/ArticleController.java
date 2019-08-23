package com.hunter.blog.modules.article.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hunter.blog.modules.article.model.ArticleDo;
import com.hunter.blog.modules.article.service.IArticleService;
import com.hunter.blog.modules.article.utils.UpFileUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static java.lang.System.out;

/**
 * @author ChenLiang
 * @version 1.0.0
 * @description
 * @time 2019/8/14 9:37
 */
@RestController
@RequestMapping(value = "/sys/article")
@CrossOrigin
public class ArticleController {

    @Autowired
    private IArticleService articleService;

    /**
     * 文章详细信息
     *
     * @param artId
     * @return
     */
    @RequestMapping(value = "/details", method = RequestMethod.GET)
    public String articleDetails(@Param("artId") int artId) {
        out.println("\033[36;4m" + "文章详细信息 articleDetails()方法执行了..." + "\033[0m");
        Map<String, Object> map = new HashMap<>(10);
        ArticleDo article = articleService.getArticleById(artId, map);

        if (article == null) {
            map.put("type", "error");
            map.put("msg", "文章不存在");
            return JSONObject.toJSONString(map);
        }
        map.put("type", "success");
        map.put("msg", "ok");
        map.put("Article", article);
        return JSONObject.toJSONString(map);
    }

    /**
     * 发布文章
     *
     * @param articleDo
     * @param articleFile
     * @param request
     * @return
     */
    @RequestMapping(value = "/postArticle", method = RequestMethod.POST, headers = "Content-Type= multipart/form-data")
    public String postArticle(@ModelAttribute ArticleDo articleDo,
                              @RequestParam(value = "articleFile", required = false) MultipartFile articleFile,
                              HttpServletRequest request) {
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
