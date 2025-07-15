package com.kh.service;

import java.util.List;

import com.kh.domain.Item;
import com.kh.domain.Member;
import com.kh.domain.UserItem;

public interface UserItemService {

	// 구매 상품 등록 처리
	public void register(Member member, Item item) throws Exception;
	// 구매 상품 보기
	public UserItem read(Integer userItemNo) throws Exception;
	// 구매 상품 목록
	public List<UserItem> list(Integer userNo) throws Exception;
}
