package com.kh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.domain.Member;
import com.kh.domain.MemberAuth;
import com.kh.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberMapper mapper;

	// 회원 권한생성
	public void register(Member member) throws Exception {
		mapper.createAuth(member);
		MemberAuth memberAuth = new MemberAuth();
		memberAuth.setAuth("ROLE_MEMBER");
		mapper.createAuth(memberAuth);
		mapper.deleteAuth(userNo);
	}

	// 회원 권한삭제
	// mapper.deleteAuth(userNo);

	// 회원 권한수정
	public void modify(Member member) throws Exception {
		mapper.update(member);
		int userNo = member.getUserNo();
		mapper.deleteAuth(userNo);
	}

	public void List<MemberAuth>authList=member.getAuthList();
	for( int i = 0;i<authList.size();i++) {
		MemberAuth memberAuth = authList.get(i);
		String auth = memberAuth.getAuth();
		if (auth == null) {
			continue;
		}
		if (auth.trim().length() == 0) {
			continue;
		}
		memberAuth.setUserNo(userNo);
		mapper.createAuth(memberAuth);
	}
}

