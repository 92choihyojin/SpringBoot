package com.kh.common.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kh.common.security.domain.CustomUser;
import com.kh.domain.Member;
import com.kh.domain.MemberAuth;
import com.kh.mapper.AuthMapper;
import com.kh.mapper.MemberMapper;
import com.kh.service.AuthService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private MemberMapper memberMapper;
	
	@Autowired
	private AuthService service;

	// 사용자 정의 유저 상세 클래스 메서드-loadUserByUsername의 Username은 userId이다.
	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		log.info("Load User By UserId : " + userId);
		Member member = null;
		if (userId == null || userId.trim().isEmpty()) {
		    throw new UsernameNotFoundException("아이디를 입력해주세요.");
		} else {
			member = memberMapper.readByUserId(userId);
			
			if (member == null) {
				log.warn("User not found: " + userId);
				throw new UsernameNotFoundException("User not found with userId: " + userId);
			}
		}
		
		int tmpAuthNo = 3;
		for(MemberAuth ma: member.getAuthList()) {
			if(tmpAuthNo > ma.getAuthNo()) {
				tmpAuthNo = ma.getAuthNo();
			}
		}
		

		log.info("queried by member mapper: " + member);
		
		String authName = "GUEST";
		
		try {
			authName = service.selectOne(tmpAuthNo).getAuthName();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new CustomUser(member, authName);
	}
}
