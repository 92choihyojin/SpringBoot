package com.kh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.domain.CodeGroup;

@Mapper
public interface CodeGroupMapper {
		// 등록 처리
		public void register(CodeGroup codeGroup) throws Exception;

		// 상세 페이지
		public CodeGroup read(String groupCode) throws Exception;

		// 수정 처리
		public void update(CodeGroup codeGroup) throws Exception;

		// 파일 삭제
		public void delete(CodeGroup codeGroup) throws Exception;

		// 목록 페이지<전체>
		public List<CodeGroup> list() throws Exception;
}
