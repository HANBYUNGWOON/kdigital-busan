package com.demoweb.dao;

import com.demoweb.vo.MemberVO;

public interface MemberDao {

	void insertMember(MemberVO member);

	MemberVO selectMemberByIdAndPasswd(String memberId, String passwd);

}