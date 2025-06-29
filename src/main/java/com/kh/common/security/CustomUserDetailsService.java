package com.kh.common.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kh.common.security.domain.CustomUser;
import com.kh.domain.Member;
import com.kh.mapper.MemberMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private MemberMapper memberMapper;

	// 사용자 정의 유저 상세 클래스 메서드-loadUserByUsername의 Username은 userId이다.
	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		log.info("Load User By UserId : " + userId);
		Member member = memberMapper.readByUserId(userId);

		if (member == null) {
			log.warn("User not found: " + userId);
			throw new UsernameNotFoundException("User not found with userId: " + userId);
		}

		log.info("queried by member mapper: " + member);
		return new CustomUser(member);
	}
}
