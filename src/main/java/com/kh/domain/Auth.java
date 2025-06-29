package com.kh.domain;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Auth {
	@NotBlank
	private int authNo;
	@NotBlank
	private String authName;
	private Date regDate;
	private Date updDate;
	private String isDelete;
}
