package com.hunter.blog.core.database.sqlSession.impl;

import com.hunter.blog.core.database.sqlSession.IBaseDao;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.xml.bind.annotation.XmlID;

/**
 * @author ChenLiang
 * @version 1.0.0
 * @description SqlSession基础dao接口实现类
 * @time 2019/8/13 14:26
 */
@Repository
public class IBaseDaoImpl implements IBaseDao {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Override
    public <T> T selectOne(String xmlID, Object param) {
        return sqlSessionTemplate.selectOne(xmlID, param);
    }
}
