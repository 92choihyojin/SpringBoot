package com.kh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.domain.CodeDetail;
import com.kh.domain.CodeGroup;

@Mapper
public interface CodeGroupMapper {
	// 등록 처리
	public void register(CodeGroup codeGroup) throws Exception;

	// 목록 페이지<전체>
	public List<CodeGroup> list() throws Exception;

	// 상세 페이지(수정 페이지)
	public CodeGroup read(String groupCode) throws Exception;

	// 수정 처리
	public void update(CodeGroup codeGroup) throws Exception;

	// 삭제 처리
	public void delete(String groupCode) throws Exception;

	//
	public int getMaxSortSeq(String groupCode) throws Exception;

	//
	public void create(CodeDetail codeDetail) throws Exception;

}
