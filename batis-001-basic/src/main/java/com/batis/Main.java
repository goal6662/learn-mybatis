package com.batis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) throws IOException {

        // 获取 SqlSessionFactoryBuilder 对象
        SqlSessionFactoryBuilder sessionFactoryBuilder = new SqlSessionFactoryBuilder();

        // 读取配置文件
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sessionFactory = sessionFactoryBuilder.build(inputStream);

        // 创建 session 会话
        SqlSession sqlSession = sessionFactory.openSession(true);   // true 自动提交事务

        // 执行 SQL 语句
        int car = sqlSession.insert("insertCar");
        System.out.println(car);

//        sqlSession.commit();    // 按需提交事务

        // 关闭会话
        sqlSession.close();
    }
}