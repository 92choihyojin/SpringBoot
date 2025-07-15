package com.kh.mapper;

import java.util.List;

import com.kh.domain.ChargeCoin;
import com.kh.domain.PayCoin;

public interface CoinMapper {

	// 충전 내역 등록
	public void create(ChargeCoin chargeCoin) throws Exception;

	// 코인 충전
	public void charge(ChargeCoin chargeCoin) throws Exception;

	// 충전 내역 조회
	public List<ChargeCoin> list(int userNo) throws Exception;

	// 코인 지급
	public void pay(PayCoin payCoin) throws Exception;

	// 구매 내역 등록
	public void createPayHistory(PayCoin payCoin) throws Exception;

	// 구매 내역 조회
	public List<PayCoin> listPayHistory(int userNo) throws Exception;
}
