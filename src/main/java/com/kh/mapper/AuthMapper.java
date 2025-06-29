package com.kh.mapper;

import java.util.List;

import com.kh.domain.Auth;

public interface AuthMapper {
	// 그룹코드 목록 조회
	public List<Auth> selectAll() throws Exception;
	// 지정된 그룹코드에 해당하는 코드 목록 조회
	public Auth selectOne(int authNo) throws Exception;
}
