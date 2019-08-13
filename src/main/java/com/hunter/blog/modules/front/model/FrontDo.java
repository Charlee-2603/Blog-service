package com.hunter.blog.modules.front.model;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author ChenLiang
 * @version 1.0.0
 * @description 首页前端展示实体类
 * @time 2019/8/13 17:34
 */
@Component
public class FrontDo implements Serializable {
    /**
     * 首页key
     */
    private String sys_key;
    /**
     * 标题
     */
    private String sys_title;
    /**
     * 头像
     */
    private String sys_avatar;
    /**
     * 描述
     */
    private String sys_desc;
    /**
     * 是否删除
     */
    private String is_deleted;

    public String getSys_key() {
        return sys_key;
    }

    public void setSys_key(String sys_key) {
        this.sys_key = sys_key;
    }

    public String getSys_title() {
        return sys_title;
    }

    public void setSys_title(String sys_title) {
        this.sys_title = sys_title;
    }

    public String getSys_avatar() {
        return sys_avatar;
    }

    public void setSys_avatar(String sys_avatar) {
        this.sys_avatar = sys_avatar;
    }

    public String getSys_desc() {
        return sys_desc;
    }

    public void setSys_desc(String sys_desc) {
        this.sys_desc = sys_desc;
    }

    public String getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(String is_deleted) {
        this.is_deleted = is_deleted;
    }

    @Override
    public String toString() {
        return "FrontDo{" +
                "sys_key='" + sys_key + '\'' +
                ", sys_title='" + sys_title + '\'' +
                ", sys_avatar='" + sys_avatar + '\'' +
                ", sys_desc='" + sys_desc + '\'' +
                ", is_deleted='" + is_deleted + '\'' +
                '}';
    }
}
