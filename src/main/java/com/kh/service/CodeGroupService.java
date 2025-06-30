package com.kh.service;

import java.util.List;

import com.kh.domain.CodeDetail;
import com.kh.domain.CodeGroup;

public interface CodeGroupService {
	// 등록 처리
	public void register(CodeGroup codeGroup) throws Exception;

	// 목록 페이지
	public List<CodeGroup> list() throws Exception;

	// 상세 페이지 (수정 페이지)
	public CodeGroup read(String groupCode) throws Exception;

	// 수정 처리
	public void update(CodeGroup codeGroup) throws Exception;
	
	// 삭제 처리
	public void delete(CodeGroup codeGroup) throws Exception;

	
}
