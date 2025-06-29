package com.kh.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import com.kh.common.security.CustomAccessDeniedHandler;
import com.kh.common.security.CustomLoginSuccessHandler;
import com.kh.common.security.CustomUserDetailsService;

import lombok.extern.java.Log;

@Log
@Configuration
@EnableWebSecurity

//시큐리티 애너테이션 활성화를 위한 설정
@EnableMethodSecurity(prePostEnabled=true, securedEnabled=true)
public class SecurityConfig {
	// 데이터 소스
	@Autowired
	DataSource dataSource;

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		log.info("security config ...");
		// csrf 토큰 비활성화
//		// 인가설정
		http.authorizeHttpRequests()
		.requestMatchers("/board/**")
		.authenticated()
		.requestMatchers("/manager/**")
		.hasRole("MANAGER")
		.requestMatchers("/admin/**")
		.hasRole("ADMIN")
		.anyRequest()
		.permitAll();

		// 로그인설정
		http.formLogin();
		// http.formLogin().loginPage("/login").defaultSuccessUrl("/success");
		

		// CustomLoginSuccessHandler를 로그인 성공 처리자로 지정한다.
		http
			.csrf().disable()
			.formLogin()
			.loginPage("/auth/login") // 사용자 정의 로그인 페이지
            .loginProcessingUrl("/login") // 로그인 처리 URL
            .successHandler(createAuthenticationSuccessHandler()) // 로그인 성공 시 핸들러
            .permitAll()
        .and()
        	.logout()
        	.logoutUrl("/auth/logout")
        	.invalidateHttpSession(true)
            .logoutSuccessUrl("/") // 로그아웃 성공 시 이동 경로
            .permitAll();


		// 로그아웃을 하면 자동 로그인에 사용하는 쿠키도 삭제한다
//		http.logout()
//		.logoutUrl("/auth/logout")
//		.invalidateHttpSession(true)
//		.deleteCookies("remember-me", "JSESSION_ID");
		
		// CustomLoginSuccessHandler를 접근 거부자로 지정한다.
//		http.exceptionHandling()
//		.accessDeniedHandler(createAccessDeniedHandler());
		
		// 데이터 소스를 지정하고 테이블을 이용해서 기존 로그인 정보를 기록
		// 쿠키의 유효시간(24시간)을 지정한다.
		http.rememberMe()
		.key("zeus")
		.tokenRepository(createJDBCRepository())
		.tokenValiditySeconds(60 * 60 * 24)
		.userDetailsService(createUserDetailsService());
		return http.build();
		
	}

	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(createUserDetailsService())
		.passwordEncoder(createPasswordEncoder());
	}

	@Bean
	public PasswordEncoder createPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	// CustomLoginSuccessHandler를 스프링 빈으로 정의한다.
	@Bean
	public AuthenticationSuccessHandler createAuthenticationSuccessHandler() {
		return new CustomLoginSuccessHandler();
	}

	// CustomAccessDeniedHandler를 스프링 빈으로 정의한다.
	@Bean
	public AccessDeniedHandler createAccessDeniedHandler() {
		return new CustomAccessDeniedHandler();
	}

	// CustomUserDetailsService를 스프링 빈으로 정의한다.
	@Bean
	public UserDetailsService createUserDetailsService() {
		return new CustomUserDetailsService();
	}

	private PersistentTokenRepository createJDBCRepository() {
		JdbcTokenRepositoryImpl repo = new JdbcTokenRepositoryImpl();
		repo.setDataSource(dataSource);
		return repo;
	}
	@Bean
	public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
	    return http.getSharedObject(AuthenticationManagerBuilder.class)
	            .userDetailsService(createUserDetailsService())
	            .passwordEncoder(createPasswordEncoder())
	            .and()
	            .build();
	}
}
