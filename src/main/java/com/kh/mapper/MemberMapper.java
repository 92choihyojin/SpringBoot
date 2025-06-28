package com.kh.mapper;

import java.util.List;

import com.kh.domain.Member;
import com.kh.domain.MemberAuth;

public interface MemberMapper {

	// 등록 처리
	public void create(Member member) throws Exception;

	// 권한 생성
	public void createAuth(MemberAuth memberAuth) throws Exception;

	// 멤버 목록
	public List<Member> list() throws Exception;

	// 상세 페이지
	public Member read(int userNo) throws Exception;

}
