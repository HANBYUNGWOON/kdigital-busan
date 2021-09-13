package com.demoweb.service;

import java.util.List;

import com.demoweb.vo.BoardVO;

public interface BoardService {
	
	int writeBoard(BoardVO board);

	List<BoardVO> findAll();

	BoardVO findBoardByBoardNo(int boardNo);

}
