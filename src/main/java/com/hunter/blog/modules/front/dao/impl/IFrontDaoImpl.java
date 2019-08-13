//package com.hunter.blog.modules.front.dao.impl;
//
//import com.hunter.blog.core.database.sqlSession.IBaseDao;
//import com.hunter.blog.modules.front.dao.IFrontDao;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
///**
// * @author ChenLiang
// * @version 1.0.0
// * @description
// * @time 2019/8/13 14:21
// */
////@MapperScan("com/hunter/blog/modules/front/mapper/frontMapper.xml")
//@Repository
//public class IFrontDaoImpl implements IFrontDao {
//
//    @Autowired
//    private SqlSessionTemplate sqlSessionTemplate;
//
//    @Override
//    public Object getSysConfig(String sysKey) {
//        System.out.println(sysKey);
//        return sqlSessionTemplate.selectOne(sysKey);
////      return baseDao.selectOne("front.getSysConfig", sysKey);
//    }
//}
