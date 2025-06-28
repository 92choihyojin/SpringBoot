package com.kh.service;

import java.util.List;

import com.kh.domain.Member;

public interface MemberService {
	// 등록 처리
	public void register(Member member) throws Exception;
//
//	// 목록 페이지
//	public List<Member> list() throws Exception;
//
//	// 상세 페이지
//	public Member read(int userNo) throws Exception;
}
