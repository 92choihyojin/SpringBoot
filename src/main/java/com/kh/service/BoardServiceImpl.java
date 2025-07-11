package com.kh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.common.domain.PageRequest;
import com.kh.domain.Board;
import com.kh.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper mapper;

	// 게시글 등록 처리
	@Override
	public void register(Board board) throws Exception {
		mapper.register(board);
	}

	// 게시글 목록 페이지(기존 소스 사용안함)
//	@Override
//	public List<Board> list() throws Exception {
//		return mapper.list();
//	}
	
	// 게시글 목록 페이지 ( 페이징 요청 )
	@Override
	public List<Board> list(PageRequest pageRequest) throws Exception {
		return mapper.list(pageRequest);
	}

	// 게시글 상세 페이지
	@Override
	public Board read(Integer boardNo) throws Exception {
		return mapper.read(boardNo);
	}

	// 게시글 수정 처리
	@Override
	public void modify(Board board) throws Exception {
		mapper.update(board);
	}

	// 게시글 삭제 처리
	@Override
	public void delete(Integer boardNo) throws Exception {
		mapper.delete(boardNo);
	}
	
	// 게시글 전체 건수를 반환 ( 기존 소스코드 사용안함 )
//	@Override
//	public int count() throws Exception {
//		return mapper.count();
//	}
	// 게시글 전체 건수를 반환
	@Override
	public int count(PageRequest pageRequest) throws Exception {
		return mapper.count(pageRequest);
	}
	
}
