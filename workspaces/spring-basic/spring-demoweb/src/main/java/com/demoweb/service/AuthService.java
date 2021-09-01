package com.demoweb.service;

import com.demoweb.vo.MemberVO;

public interface AuthService {

	void registerMember(MemberVO member);

	MemberVO findMemberByIdAndPasswd(String memberId, String passwd);

}