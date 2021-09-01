package com.demoweb.vo;

import java.sql.Date;

// VO : 데이터 저장용 클래스 -> 일반적으로 데이터베이스 테이블에 대응하는 클래스
public class MemberVO {
	
	// VO 클래스의 필드(변수)는 데이터베이스 테이블의 컬럼과 일치하도록 구현
	private String memberId;
	private String passwd;
	private String email;
	private String userType;
	private boolean active;
	private Date regDate;
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

}
