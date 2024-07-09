package com.batis.test;

import com.batis.model.Car;
import com.batis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class CarMapperTest {


    @Test
    public void queryCarTest() {

        SqlSession sqlSession = SqlSessionUtil.openSession();

        Car car = new Car();
        car.setId(1L);
        Object object = sqlSession.selectOne("getById", car);

        System.out.println(object);
    }

    @Test
    public void insertCarTest() {

        SqlSession sqlSession = SqlSessionUtil.openSession();

//        Map<String, Object> args = new HashMap<>();
//        args.put("carNum", "1005");
//        args.put("brand", "比亚迪唐");
//        args.put("guidePrice", 10.0);
//        args.put("produceTime", "2020-01-01");
//        args.put("carType", "新能源");


        Car args = new Car(null, "1010", "比亚迪汉",
                new BigDecimal("15.0"), "2021-12-09", "新能源");

        sqlSession.insert("insertCar", args);

        sqlSession.commit();
        sqlSession.close();

    }

}
