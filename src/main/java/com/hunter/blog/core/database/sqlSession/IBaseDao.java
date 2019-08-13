package com.hunter.blog.core.database.sqlSession;

/**
 * @author ChenLiang
 * @version 1.0.0
 * @description SqlSession基础dao接口类
 * @data: 2019/8/13 14:25
 */
public interface IBaseDao {

    /**
     * 根据参数映射XMlID,返回一个对象
     * @param xmlID
     * @param param
     * @param <T>
     * @return
     */
    <T> T selectOne(String xmlID, Object param);
}
