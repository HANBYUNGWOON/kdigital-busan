package com.demoweb.dao;

import java.util.List;

import com.demoweb.vo.BoardVO;

public interface BoardDao {
	
	int insertBoard(BoardVO board);

	List<BoardVO> selectAll();

}
