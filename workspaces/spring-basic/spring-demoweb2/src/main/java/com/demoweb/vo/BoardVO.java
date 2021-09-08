package com.demoweb.vo;

import java.util.Date;

import lombok.Data;

// 데이터베이스의 Board 테이블에 매핑되는 VO 클래스
@Data // 클래스의 모든 필드에 대해 getter, setter 를 자동으로 만들어주는 annotation
public class BoardVO {
	
	// VO 클래스의 필드는 매핑되는 테이블의 컬럼과 동일하게 정의
	private int boardNo;
	private String title;
	private String writer;
	private String content;
	private int readCount;
	private boolean deleted;
	private Date regDate;
	
}
