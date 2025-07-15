package com.kh.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kh.common.domain.PageRequest;
import com.kh.domain.Board;

public interface BoardService {

	// 게시글 등록 처리
	public void register(Board board) throws Exception;
	
	// 게시글 목록 페이지 (기존소스 사용안함)
//	public List<Board> list() throws Exception;

	// 게시글 목록 페이지 (페이징 처리를 위해 추가)
	public List<Board> list(PageRequest pageRequest) throws Exception;
	
	// 게시글 상세 페이지
	public Board read(Integer boardNo) throws Exception;

	// 게시글 수정 처리
	public void modify(Board board) throws Exception;

	// 게시글 삭제 처리
	public void delete(Integer boardNo) throws Exception;
	
	// 게시글 전체 건수를 반환 ( 기존 소스코드 사용안함 )
	//public int count() throws Exception;
	
	// 검색 처리된 게시글 건수를 반환
	public int count(PageRequest pageRequest) throws Exception;
}
