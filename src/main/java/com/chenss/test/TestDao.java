package com.chenss.test;

import com.chenss.mapper.OperaEnvDAO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class TestDao {
    public static void main(String[] args) throws IOException {
        String resources="mybatis.xml";
        InputStream is = Resources.getResourceAsStream(resources);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = factory.openSession();

        OperaEnvDAO dao = session.getMapper(OperaEnvDAO.class);
        System.out.println(dao.selectByPrimaryKey(1));
        session.close();
    }
}
