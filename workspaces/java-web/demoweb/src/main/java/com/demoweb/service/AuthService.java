package com.demoweb.service;

import com.demoweb.dao.MemberDao;
import com.demoweb.vo.MemberVO;

public class AuthService {
	
	public void registerMember(MemberVO member) {

		MemberDao memberDao = new MemberDao();
		memberDao.insertMember(member);
		
	}

}
