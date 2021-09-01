package com.demoweb.service;

import com.demoweb.common.Util;
import com.demoweb.dao.MemberDao;
import com.demoweb.vo.MemberVO;

public class AuthService {
	
	public void registerMember(MemberVO member) {
		
		//passwd 암호화
		String hashedPasswd = Util.getHashedString(member.getPasswd(), "SHA-256");
		member.setPasswd(hashedPasswd);
		
		MemberDao memberDao = new MemberDao();
		memberDao.insertMember(member);
		
	}

	public MemberVO findMemberByIdAndPasswd(String memberId, String passwd) {
		
		//passwd 암호화
		passwd = Util.getHashedString(passwd, "SHA-256");
		
		MemberDao memberDao = new MemberDao();
		MemberVO member = memberDao.selectMemberByIdAndPasswd(memberId, passwd);
		return member;
		
	}
	
}
