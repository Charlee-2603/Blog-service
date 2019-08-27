package com.hunter.blog.utils.code;

import com.google.code.kaptcha.Constants;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ChenLiang
 * @version 1.0.0
 * @description 新建验证码比对工具类
 * @data: 2019/8/26 20:14
 */
public class CodeUtil {

    /**
     * 将获取到的前端参数转为string类型
     *
     * @param request
     * @param key
     * @return
     */
    public static String getString(HttpServletRequest request, String key) {
        try {
            String result = request.getParameter(key);
            if (result != null) {
                result = result.trim();
            }
            if ("".equals(result)) {
                result = null;
            }
            return result;
        } catch (Exception e) {
            return null;
        }
    }


    /**
     * 验证码校验
     *
     * @param request
     * @return
     */
    public static boolean checkVerifyCode(HttpServletRequest request) {
        // 获取生成的验证码
        Jedis jedis = new Jedis("localhost");
//        jedis.get();
        String verifyCodeExpected = (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        System.out.println("获取生成的验证码:" + verifyCodeExpected);

        // 获取用户输入的验证码
        String verifyCodeActual = CodeUtil.getString(request, "user_code");
        System.out.println("获取用户输入的验证码:" + verifyCodeActual);
        if (verifyCodeActual == null || !verifyCodeActual.equals(verifyCodeExpected)) {
            return false;
        }
        return true;
    }
}
