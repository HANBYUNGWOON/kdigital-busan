package com.demoweb.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.demoweb.vo.BoardVO;

import lombok.Setter;

public class JdbcTemplateBoardDaoImpl implements BoardDao {

	@Setter
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int insertBoard(BoardVO board) {
		
		jdbcTemplate.update("INSERT INTO BOARD (TITLE, WRITER, CONTENT) VALUES (?, ?, ?)", 
							board.getTitle(), board.getWriter(), board.getContent());
		
		return 0;
	}

}
