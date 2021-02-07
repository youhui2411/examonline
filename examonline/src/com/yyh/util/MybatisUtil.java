package com.yyh.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Description: com.yyh.util
 * @version: 1.0
 */
public class MybatisUtil {
    private static SqlSessionFactory factory;
    private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<>();
    static{
        try {
            InputStream is = Resources.getResourceAsStream("mybatis.xml");
            factory = new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static SqlSession getSession(){
        SqlSession session = threadLocal.get();
        if(session == null){
            threadLocal.set(factory.openSession());
        }
        return threadLocal.get();
    }


    public static void closeSession(){
        SqlSession session = threadLocal.get();
        if(session!=null){
            session.close();
        }
        threadLocal.set(null);
    }
}
