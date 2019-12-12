package com.tedu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tedu.pojo.Emp;

public interface EmpMapper {

	List<Emp> findAll();
	//@Param用来给参数命名，参数命名后，就能根据名字得到参数值，并将其传入SQL语句
	Emp findById(@Param("id") Integer id);
	int insert(@Param("emp")List<Emp> emp);
}
