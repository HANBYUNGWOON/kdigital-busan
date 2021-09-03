package com.demoweb.service;

import java.util.List;

import com.demoweb.vo.WinningNumbers;

public interface LottoService {

	void initData(String csvPath);

	List<WinningNumbers> readLottoNumbersFromCsv(String csvPath);

	int[] loadStatsByNumber(boolean includeBno, int rndFrom, int rndTo);
	
	int[] loadStatsBySection(int weeks, int range);

}