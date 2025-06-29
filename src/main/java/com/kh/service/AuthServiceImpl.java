package com.kh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.kh.domain.Auth;
import com.kh.mapper.AuthMapper;

@Service
public class AuthServiceImpl implements AuthService {
	@Autowired
	private AuthMapper mapper;
	// 그룹코드 목록 조회
	public List<Auth> selectAll() throws Exception {
		return mapper.selectAll();
	}
	// 지정된 그룹코드에 해당하는 코드 목록 조회
	public Auth selectOne(int authNo) throws Exception {
		return mapper.selectOne(authNo);
	}
}
