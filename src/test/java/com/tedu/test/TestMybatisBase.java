package com.tedu.test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

public class TestMybatisBase {
	
	protected SqlSessionFactory sqlSessionFactory;
	@Before
	public void init() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	@Test
	public void testMybatisBase() {
		SqlSession session = sqlSessionFactory.openSession();
		Connection connection = session.getConnection();
		System.out.println("工厂：" + sqlSessionFactory);
		System.out.println("session：" + session);
		System.out.println("连接：" + connection);
	}
}
