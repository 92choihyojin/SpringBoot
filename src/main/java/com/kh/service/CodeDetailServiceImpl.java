package com.kh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.domain.CodeDetail;
import com.kh.mapper.CodeDetailMapper;
import com.kh.mapper.CodeGroupMapper;

@Service
public class CodeDetailServiceImpl implements CodeDetailService {

	@Autowired
	private CodeDetailMapper mapper;

	// 등록 처리
	@Override
	public void register(CodeDetail codeDetail) throws Exception {
		String groupCode = codeDetail.getGroupCode();
		int maxSortSeq = mapper.getMaxSortSeq(groupCode);
		codeDetail.setSortSeq(maxSortSeq + 1);
		mapper.register(codeDetail);
	}

	// 목록 페이지
	@Override
	public List<CodeDetail> list() throws Exception {
		return mapper.list();
	}

	// 상세 페이지
	@Override
	public CodeDetail read(CodeDetail codeDetail) throws Exception {
		return mapper.read(codeDetail);
	}

	// 수정 처리
	@Override
	public void modify(CodeDetail codeDetail) throws Exception {
		mapper.update(codeDetail);
	}

	// 삭제 처리
	@Override
	public void remove(CodeDetail codeDetail) throws Exception {
		mapper.delete(codeDetail);
	}
}
