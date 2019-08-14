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
    private String sysKey;
    /**
     * 名称
     */
    private String sysName;
    /**
     * 头像
     */
    private String sysValue;
    /**
     * 描述
     */
    private String sysDesc;
    /**
     * 是否删除
     */
    private String isDeleted;

    public String getSysKey() {
        return sysKey;
    }

    public void setSysKey(String sysKey) {
        this.sysKey = sysKey;
    }

    public String getSysName() {
        return sysName;
    }

    public void setSysName(String sysName) {
        this.sysName = sysName;
    }

    public String getSysValue() {
        return sysValue;
    }

    public void setSysValue(String sysValue) {
        this.sysValue = sysValue;
    }

    public String getSysDesc() {
        return sysDesc;
    }

    public void setSysDesc(String sysDesc) {
        this.sysDesc = sysDesc;
    }

    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        return "FrontDo{" +
                "sysKey='" + sysKey + '\'' +
                ", sysName='" + sysName + '\'' +
                ", sysValue='" + sysValue + '\'' +
                ", sysDesc='" + sysDesc + '\'' +
                ", isDeleted='" + isDeleted + '\'' +
                '}';
    }
}
