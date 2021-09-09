package com.demoweb.service;

import com.demoweb.dao.BoardDao;
import com.demoweb.vo.BoardVO;

import lombok.Setter;

public class BoardServiceImpl implements BoardService {

	@Setter // setBoardDao를 자동으로 만드는 annotation
	private BoardDao boardDao;
	
	@Override
	public int writeBoard(BoardVO board) {
		return 0;
	}

}
