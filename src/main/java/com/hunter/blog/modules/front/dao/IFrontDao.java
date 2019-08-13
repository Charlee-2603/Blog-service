package com.hunter.blog.modules.front.dao;

import com.hunter.blog.modules.front.model.FrontDo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ChenLiang
 * @version 1.0.0
 * @description 首页dao接口
 * @data: 2019/8/13 14:10
 */
@Mapper
@Repository
public interface IFrontDao {

    /**
     * 获取参数表的参数值
     *
     * @param sysKey
     * @return
     */
    @Select("select * from sys_config where is_deleted = 1")
    List<FrontDo> getSysConfig(String sysKey);
}
