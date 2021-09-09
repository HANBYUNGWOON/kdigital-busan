package com.demoweb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

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

	@Override
	public List<BoardVO> selectAll() {
		//jdbcTemplate(sql, params-array, 인터페이스 구현한 결과처리 객체) // 
		List<BoardVO> boards = jdbcTemplate.query(
				"SELECT BOARDNO, TITLE, WRITER, READCOUNT, REGDATE FROM BOARD ORDER BY BOARDNO DESC",
				new RowMapper<BoardVO>() {

					@Override
					public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
						BoardVO board = new BoardVO();
						board.setBoardNo(rs.getInt(1));
						board.setTitle(rs.getString(2));
						board.setWriter(rs.getString(3));
						board.setReadCount(rs.getInt(4));
						board.setRegDate(rs.getDate(5));
						return board;
					}
				}
		);
		
		return boards;
	}

}
