package com.kh.service;

import java.util.List;

import com.kh.domain.CodeGroup;

public interface CodeGroupService {
	// 등록
	void register(CodeGroup codeGroup) throws Exception;

	// 목록 페이지
	public List<CodeGroup> list() throws Exception;

	// 상세 페이지
	public CodeGroup read(String groupCode) throws Exception;

	// 수정 처리
	public void modify(CodeGroup codeGroup) throws Exception;
	
}
