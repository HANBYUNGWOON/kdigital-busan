package com.demoweb.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class WinningNumbers {

	private int rnd;
	private Date lotteryDate;
	private int no1;
	private int no2;
	private int no3;
	private int no4;
	private int no5;
	private int no6;
	private int bno;
	
	public int getRnd() {
		return rnd;
	}

	public void setRnd(int rnd) {
		this.rnd = rnd;
	}

	public Date getLotteryDate() {
		return lotteryDate;
	}

	public void setLotteryDate(Date lotteryDate) {
		this.lotteryDate = lotteryDate;
	}

	public int getNo1() {
		return no1;
	}

	public void setNo1(int no1) {
		this.no1 = no1;
	}

	public int getNo2() {
		return no2;
	}

	public void setNo2(int no2) {
		this.no2 = no2;
	}

	public int getNo3() {
		return no3;
	}

	public void setNo3(int no3) {
		this.no3 = no3;
	}

	public int getNo4() {
		return no4;
	}

	public void setNo4(int no4) {
		this.no4 = no4;
	}

	public int getNo5() {
		return no5;
	}

	public void setNo5(int no5) {
		this.no5 = no5;
	}

	public int getNo6() {
		return no6;
	}

	public void setNo6(int no6) {
		this.no6 = no6;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}
	
	// 필요하다면 생성자 메서드 구현 ( 초기화 메서드, new WinningNumbers() 하는 시점에 자동으로 호출 )
	public WinningNumbers() {}
	public WinningNumbers(int rnd, Date lotteryDate, int no1, int no2, int no3, int no4, int no5, int no6, int bno) {
		this.rnd = rnd;
		this.lotteryDate = lotteryDate;
		this.no1 = no1;
		this.no2 = no2;
		this.no3 = no3;
		this.no4 = no4;
		this.no5 = no5;
		this.no6 = no6;
		this.bno = bno;
	}
	
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return String.format("[%5d][%10s][%2d][%2d][%2d][%2d][%2d][%2d][%2d]",
							 rnd, sdf.format(lotteryDate), no1, no2, no3, no4, no5, no6, bno);
	}	
	
}
