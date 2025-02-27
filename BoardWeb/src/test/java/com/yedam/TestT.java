package com.yedam;


import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.yedam.common.DataSource;
import com.yedam.mapper.BoardMapper;
import com.yedam.vo.BoardVO;
import com.yedam.common.SearchVO;

public class TestT {
	public static void main(String[] args) {
		SqlSessionFactory sqlSessionFactory = DataSource.getInstence();
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		SearchVO sr = new SearchVO(1,"T","등");
		
		int row = mapper.getTotalCount(sr);
		System.out.println("건수  :"+ row);
		
		
		
	}
}
