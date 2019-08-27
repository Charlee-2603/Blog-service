package com.hunter.blog.utils.code;

import com.alibaba.fastjson.JSON;
import com.google.code.kaptcha.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ChenLiang
 * @version 1.0.0
 * @description 验证码控制类
 * @data: 2019/8/26 8:18
 */

@RestController
@CrossOrigin
public class CodeController {

    @Autowired
    private Producer captchaProducer = null;

    /**
     * 获取kaptcha验证码
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("/kaptcha")
    public String getCodeImage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("\033[36;4m" + "getCodeImage()方法执行了..." + "\033[0m");
        Map<String, Object> map = new HashMap<>();
        String sessionId = request.getSession().getId();

        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setContentType("image/jpeg");

        //生成验证码
        String capText = captchaProducer.createText();
        System.out.println("capText:" + capText);
        Jedis jedis = new Jedis();
        jedis.set(sessionId, capText);

        //向客户端写出
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        BufferedImage bi = captchaProducer.createImage(capText);
        ImageIO.write(bi, "jpg", outputStream);
        BASE64Encoder encoder = new BASE64Encoder();
        String base64Img = encoder.encode(outputStream.toByteArray());
        try {
            outputStream.flush();
        } finally {
            outputStream.close();
        }
        map.put("codeImg", base64Img);
        map.put("sessionId", sessionId);
        return JSON.toJSONString(map);
    }
}
