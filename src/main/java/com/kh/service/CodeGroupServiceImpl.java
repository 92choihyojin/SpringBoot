package com.kh.service;

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
}
