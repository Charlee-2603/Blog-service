package com.hunter.blog.modules.front.service;

import org.springframework.ui.ModelMap;

import java.util.Map;

/**
 * @author ChenLiang
 * @version 1.0.0
 * @description 首页service接口
 * @data: 2019/8/13 14:08
 */
public interface IFrontService {
    /**
     * 设置首页内容
     * @return
     */
    Map setHtml();
}
