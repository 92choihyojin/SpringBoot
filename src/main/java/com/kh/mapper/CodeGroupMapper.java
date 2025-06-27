package com.kh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.domain.CodeGroup;

@Mapper
public interface CodeGroupMapper {
		// 파일 삽입
		public void register(CodeGroup codeGroup) throws Exception;

		// 파일 출력
		public CodeGroup read(CodeGroup codeGroup) throws Exception;

		// 파일 수정
		public void update(CodeGroup codeGroup) throws Exception;

		// 파일 삭제
		public void delete(CodeGroup codeGroup) throws Exception;

		// 파일 출력<전체>
		public List<CodeGroup> list() throws Exception;
}
