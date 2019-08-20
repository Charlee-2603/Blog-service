package com.hunter.blog.modules.article.utils;

import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

/**
 * @author ChenLiang
 * @version 1.0.0
 * @description 文件上传
 * @data: 2019/8/20 10:16
 */
public class UpFileUtil {

    /**
     * 已时间 + 文件名称命名
     *
     * @param fileName
     * @return
     */
    public static String setUpFileName(String fileName, MultipartFile articleFile, HttpServletRequest request) throws IOException {
        long now = System.currentTimeMillis();
        String filename = now + fileName;
        return upFile(filename, articleFile, request);
    }


    /**
     * 文件上传路径
     *
     * @param filename 文件名称
     * @param request  request请求
     * @return
     * @throws FileNotFoundException
     */
    public static String upFile(String filename, MultipartFile articleFile, HttpServletRequest request) throws IOException {
        File file = new File(ResourceUtils.getURL("classpath:").getPath() + "/upload", filename);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        BufferedOutputStream out = new BufferedOutputStream(fileOutputStream);
        String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
        String artTitleImgURL = url + filename;
        out.write(articleFile.getBytes());
        out.flush();
        out.close();
        return artTitleImgURL;
    }


}
