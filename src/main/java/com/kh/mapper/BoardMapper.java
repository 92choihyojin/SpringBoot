package com.kh.mapper;

import java.util.List;

public class BoardMapper {

	// 게시글 등록 처리
	public void register(Board board) throws Exception;

	// 게시글 목록 페이지
	public List<Board> list() throws Exception;

	// 게시글 상세 페이지
	public Board read(Integer boardNo) throws Exception;

}
