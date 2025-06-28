package com.kh.mapper;

import com.kh.domain.MemberAuth;

public interface MemberMapper {
	
	// 회원 권한 생성
	public void createAuth(MemberAuth memberAuth) throws Exception;
	// 회원 권한 삭제
	public void deleteAuth(int userNo) throws Exception;
}
