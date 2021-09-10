package com.demoweb.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.demoweb.vo.BoardVO;

import lombok.Setter;

public class MyBatisBoardDaoImpl implements BoardDao {
	
	@Setter
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public int insertBoard(BoardVO board) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<BoardVO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
