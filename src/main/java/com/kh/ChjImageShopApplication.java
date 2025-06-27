package com.kh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//Mapper 인터페이스 스캔 활성화
@SpringBootApplication
@MapperScan(basePackages = "com.kh.mapper")
public class ChjImageShopApplication {
	public static void main(String[] args) {
		SpringApplication.run(ChjImageShopApplication.class, args);
	}

}
