package com.kh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.kh.domain.CodeGroup;
import com.kh.mapper.CodeGroupMapper;

@Service
@ComponentScan
public class CodeGroupServiceImpl implements CodeGroupService {
	@Autowired
	private CodeGroupMapper mapper;

	// 등록 처리
	@Override
	public void register(CodeGroup codeGroup) throws Exception {
		mapper.register(codeGroup);
	}

	// 목록 페이지
	@Override
	public List<CodeGroup> list() throws Exception {
		return mapper.list();
	}

	// 상세 페이지
	@Override
	public CodeGroup read(String groupCode) throws Exception {
		return mapper.read(groupCode);
	}

	// 수정 처리
	@Override
	public void modify(CodeGroup codeGroup) throws Exception {
		mapper.update(codeGroup);
	}
}
