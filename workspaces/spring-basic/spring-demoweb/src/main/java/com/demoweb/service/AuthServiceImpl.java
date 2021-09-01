package com.demoweb.service;

import com.demoweb.common.Util;
import com.demoweb.dao.MemberDao;
import com.demoweb.dao.MemberDaoImpl;
import com.demoweb.vo.MemberVO;

public class AuthServiceImpl implements AuthService {
	
	private MemberDao memberDao;	
	public void setMemberDao(MemberDao memberDao) {//의존 객체 주입을 위한 setter
		this.memberDao = memberDao;
	}

	@Override
	public void registerMember(MemberVO member) {
		
		//passwd 암호화
		String hashedPasswd = Util.getHashedString(member.getPasswd(), "SHA-256");
		member.setPasswd(hashedPasswd);
		
		//MemberDao memberDao = new MemberDaoImpl();
		memberDao.insertMember(member);
		
	}

	@Override
	public MemberVO findMemberByIdAndPasswd(String memberId, String passwd) {
		
		//passwd 암호화
		passwd = Util.getHashedString(passwd, "SHA-256");
		
		// MemberDao memberDao = new MemberDaoImpl();
		MemberVO member = memberDao.selectMemberByIdAndPasswd(memberId, passwd);
		return member;
		
	}
	
}
