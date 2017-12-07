package com.junlon.web.portal.controller;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Author: LuJunLang
 * @Description:
 * @Date: 2017/12/4
 */

@Repository("adminDao")
public class AdminDaoImpl extends SqlSessionDaoSupport implements AdminDao {

    /**
     * 注入SqlSessionTemplate实例(要求Spring中进行SqlSessionTemplate的配置).<br/>
     * 可以调用sessionTemplate完成数据库操作.
     */
    @Autowired
    private SqlSessionTemplate sessionTemplate;

    @Autowired
    protected SqlSessionFactory sqlSessionFactory;

    @Autowired
    private DruidDataSource druidDataSource;

    public SqlSessionTemplate getSessionTemplate() {
        return sessionTemplate;
    }

    public void setSessionTemplate(SqlSessionTemplate sessionTemplate) {
        this.sessionTemplate = sessionTemplate;
    }

    public SqlSession getSqlSession() {
        //一定要使用super
        return super.getSqlSession();
    }

    @Resource
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        //一定要使用super
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    public String getStatement(String sqlId) {

        String name = this.getClass().getName();

        StringBuffer sb = new StringBuffer().append(name).append(".").append(sqlId);

        return sb.toString();
    }

    @Override
    public List<Admin> list(Map<String, Object> paramMap) {
        List<Admin> list = getSqlSession().selectList(getStatement("listPage"), paramMap);
        return list;
    }
}
