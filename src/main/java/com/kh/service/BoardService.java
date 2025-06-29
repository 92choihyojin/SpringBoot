package com.kh.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class BoardService {

	// 게시글 등록 처리
	public void register(Board board) throws Exception;

	// 게시글 목록 페이지
	public List<Board> list() throws Exception;

	// 게시글 상세 페이지
	public Board read(Integer boardNo) throws Exception;

}
