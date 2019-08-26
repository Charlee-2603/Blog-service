package com.hunter.blog.modules.user.model;

/**
 * @author ChenLiang
 * @version 1.0.0
 * @description 用户实体类
 * @data: 2019/8/26 8:42
 */
public class UserDo {
    /**
     * 用户ID
     */
    private Integer user_id;
    /**
     * 用户名称
     */
    private String user_name;
    /**
     * 用户密码
     */
    private String user_password;

    /**
     * 用户状态
     */
    private Integer user_status;

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public Integer getUser_status() {
        return user_status;
    }

    public void setUser_status(Integer user_status) {
        this.user_status = user_status;
    }

    @Override
    public String toString() {
        return "UserDo{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", user_password='" + user_password + '\'' +
                ", user_status=" + user_status +
                '}';
    }
}
