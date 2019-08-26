package com.hunter.blog.modules.user.dao;

import com.hunter.blog.modules.user.model.UserDo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author ChenLiang
 * @version 1.0.0
 * @description 用户dao接口
 * @data: 2019/8/26 9:02
 */
@Mapper
@Repository
public interface IUserDao {

    /**
     * 用户登录（判断用户是否存在）
     *
     * @param userDo
     * @return
     */
    int userLogin(@Param("userDo") UserDo userDo);
}
