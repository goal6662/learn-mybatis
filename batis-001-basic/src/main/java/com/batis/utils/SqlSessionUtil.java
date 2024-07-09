package com.batis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class SqlSessionUtil {

    private SqlSessionUtil(){
    }

    private static final SqlSessionFactory sqlSessionFactory;

    static {
        try {
            // 获取 SqlSessionFactoryBuilder 对象
            SqlSessionFactoryBuilder sessionFactoryBuilder = new SqlSessionFactoryBuilder();
            // 读取配置文件
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            sqlSessionFactory = sessionFactoryBuilder.build(inputStream);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static SqlSession openSession() {
        return sqlSessionFactory.openSession();
    }

}
