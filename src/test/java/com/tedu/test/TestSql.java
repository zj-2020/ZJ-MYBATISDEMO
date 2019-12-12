package com.tedu.test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.tedu.dao.EmpMapper;
import com.tedu.pojo.Emp;

public class TestSql extends TestMybatisBase{

	@Test
	public void testFindAll() throws IOException {
		//1.读取核心配置文件mybatis-config.xml,获取基本信息
		InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
		//2.根据配置信息生成SqlSessionFactory工厂对象
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
		//3.通过工厂获取一个SqlSession对象（用于执行SQL及返回结果）
		SqlSession session = sqlSessionFactory.openSession(true);
		//4.执行SQL语句，查询emp表中所有记录，封装到List集合中
		EmpMapper empMapper = session.getMapper(EmpMapper.class);
		List<Emp> lists = empMapper.findAll();
		//5.打印list集合
		for(Emp list : lists) {
			System.out.println(list);
		}
	}

	/**获取代理对象*/
	@Test
	public void testFindById() throws IOException {
		SqlSession session = sqlSessionFactory.openSession(true);
		EmpMapper empMapper = session.getMapper(EmpMapper.class);
		Emp emp = empMapper.findById(4);
		System.out.println(emp);
	}
	
	/**调用SqlSeesion的方法去执行SQL语句*/
	@Test
	public void testInsert() {
		SqlSession session = sqlSessionFactory.openSession(true);
		Emp emp = new Emp();
		emp.setId(1);
		emp.setJob("讲师");
		emp.setName("李四");
		emp.setSalary(1000.0);
		int row = session.insert("com.tedu.dao.EmpMapper.insert",emp);
		System.out.println("插入" + row + "行");
		
	}
}
