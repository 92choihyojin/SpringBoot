package com.kh.mapper;

import java.util.List;

import com.kh.common.CodeLabelValue;

public interface CodeMapper {
	// 그룹코드 목록 조회
	public List<CodeLabelValue> getCodeGroupList() throws Exception;
	// 그룹코드 목록 조회
	public List<CodeLabelValue> getCodeList() throws Exception;
}
