package com.kh.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@RequiredArgsConstructor:final 필드와 @NonNull 필드에 대한 생성자 자동 생성
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class CodeLabelValue {
	private final String value;
	private final String label;
}
