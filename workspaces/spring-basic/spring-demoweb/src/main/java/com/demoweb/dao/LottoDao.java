package com.demoweb.dao;

import java.util.List;

import com.demoweb.vo.WinningNumbers;

public interface LottoDao {

	void dropWinningNumbersTable();

	void createWinningNumbersTable();

	void insertWinningNumbers(WinningNumbers wn);

	// 한 번에 여러 개의 데이터를 insert하는 메서드
	void insertWinningNumbers2(List<WinningNumbers> numbers);

	// 번호별로 1등 당첨에 포함된 횟수 조회
	int[] selectStatsByNumber(boolean includeBno, int rndFrom, int rndTo);

}