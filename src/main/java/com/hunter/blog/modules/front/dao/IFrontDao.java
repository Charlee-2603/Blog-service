package com.hunter.blog.modules.front.dao;

import com.hunter.blog.modules.front.model.FrontDo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

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
    List<FrontDo> getSysConfig(@Param(value = "sysKey") String sysKey);
}
