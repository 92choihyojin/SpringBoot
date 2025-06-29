package com.kh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.domain.Member;
import com.kh.domain.MemberAuth;
import com.kh.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberMapper mapper;

	// 등록 처리
	@Transactional
	@Override
	public void register(Member member) throws Exception {
		mapper.create(member);
	}

	// 목록 페이지
	@Override
	public List<Member> list() throws Exception {
		return mapper.list();
	}

	// 상세 페이지
	@Override
	public Member read(int userNo) throws Exception {
		return mapper.read(userNo);
	}

	// 수정 처리
	@Override
	public void modify(Member member) throws Exception {
		// TODO Auto-generated method stub

	}

	// 삭제 처리
	@Override
	public void remove(int userNo) throws Exception {
		// TODO Auto-generated method stub

	}

	// 회원 테이블의 데이터 건수를 반환
	@Override
	public int countAll() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	// 최초 관리자를 생성한다.
	@Transactional
	@Override
	public void setupAdmin(Member member) throws Exception {
		mapper.create(member);
		MemberAuth memberAuth = new MemberAuth();
		memberAuth.setUserNo(member.getUserNo());
		memberAuth.setAuth("ROLE_ADMIN");
		mapper.createAuth(memberAuth);
	}
}
