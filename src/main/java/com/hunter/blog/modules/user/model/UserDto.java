package com.hunter.blog.modules.user.model;

import java.io.Serializable;

/**
 * 用户扩展类
 *
 * @author ChenLiang
 * @version 1.0.0
 * @data: 2019/8/27 14:06
 */
public class UserDto extends UserDo implements Serializable {
    /**
     * sessionId
     */
    private String sessionId;
    private String code;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "UserDo{" + super.toString() + "}" +
                "UserDto{" +
                "sessionId='" + sessionId + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
