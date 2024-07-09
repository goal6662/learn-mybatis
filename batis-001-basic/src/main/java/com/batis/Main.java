package com.batis;

import com.batis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        SqlSession sqlSession = SqlSessionUtil.openSession();

        // 执行 SQL 语句
        int car = sqlSession.insert("insertCar");
        System.out.println(car);

//        sqlSession.commit();    // 按需提交事务

        // 关闭会话
        sqlSession.close();
    }
}