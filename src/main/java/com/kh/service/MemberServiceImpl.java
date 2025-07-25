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
		mapper.register(member);

		// 회원 권한 생성
		MemberAuth memberAuth = new MemberAuth();

		memberAuth.setUserNo(mapper.readMemberById(member.getUserId()));
		memberAuth.setAuthNo(mapper.readAuthByName("ROLE_GUEST"));

		mapper.createAuth(memberAuth);
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
	@Transactional
	@Override
	public void modify(Member member) throws Exception {
		mapper.update(member);
		// 회원권한 수정
		int userNo = member.getUserNo();
		// 회원권한 삭제
		mapper.deleteAuth(userNo);
		List<MemberAuth> authList = member.getAuthList();
		for (int i = 0; i < authList.size(); i++) {
			MemberAuth memberAuth = authList.get(i);
			String auth = memberAuth.getAuth();
			if (auth == null) {
				continue;
			}
			if (auth.trim().length() == 0) {
				continue;
			}
			// 변경된 회원권한 추가 memberAuth.setUserNo(userNo); mapper.modifyAuth(memberAuth);
		}
	}

	// 삭제 처리
	@Transactional
	@Override
	public void remove(int userNo) throws Exception {
		// 회원 권한 삭제
		mapper.deleteAuth(userNo);
		mapper.delete(userNo);
	}

	// 회원 테이블의 데이터 건수를 반환
	@Override
	public int countAll() throws Exception {
		return mapper.countAll();
	}

	// 최초 관리자를 생성한다.
	@Transactional
	@Override
	public void setupAdmin(Member member) throws Exception {
		mapper.register(member);

		MemberAuth memberAuth = new MemberAuth();

		memberAuth.setUserNo(member.getUserNo());
		memberAuth.setAuth("ROLE_ADMIN");
		mapper.createAuth(memberAuth);
	}

	// 회원의 코인을 반환한다.
	@Override
	public int getCoin(int userNo) throws Exception {
		Member member = mapper.read(userNo);
		return member.getCoin();
	}
}
