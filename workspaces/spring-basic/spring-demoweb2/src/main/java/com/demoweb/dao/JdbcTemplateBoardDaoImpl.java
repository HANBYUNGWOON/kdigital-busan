package com.demoweb.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.demoweb.vo.BoardVO;

import lombok.Setter;

public class JdbcTemplateBoardDaoImpl implements BoardDao {

	@Setter
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int insertBoard(BoardVO board) {
		return 0;
	}

}
