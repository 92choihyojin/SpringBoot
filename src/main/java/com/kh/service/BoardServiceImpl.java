package com.kh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.mapper.BoardMapper;

@Service
public class BoardServiceImpl {

	@Autowired
	private BoardMapper mapper;

	// 게시글 등록 처리
	@Override
	public void register(Board board) throws Exception {

	}

	// 게시글 목록 페이지
	@Override
	public List<Board> list() throws Exception {
		return mapper.list();
	}

	// 게시글 상세 페이지
	@Override
	public Board read(Integer boardNo) throws Exception {
		return mapper.read(boardNo);
	}

}
