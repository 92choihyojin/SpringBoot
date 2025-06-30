package com.kh.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberAuth {
	private int userNo;
	private String auth;
	
	public int getUserNo() {
        return userNo;
    }
    public void setUserNo(int userNo) {
        this.userNo = userNo;
    }

    public String getAuth() {
        return auth;
    }
    public void setAuth(String authNo) {
        this.auth = auth;
    }

}
