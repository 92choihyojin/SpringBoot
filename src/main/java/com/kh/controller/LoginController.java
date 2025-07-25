package com.kh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/auth")
public class LoginController {

	// 로그인 페이지
	@GetMapping("/login")
	public String loginForm(String error, String logout, Model model) {
		if (error != null) {
			model.addAttribute("error", "로그인 에러!!!");
		}
		if (logout != null) {
			model.addAttribute("logout", "로그아웃!!!");
		}
		return "auth/loginForm";
	}
	
//	@PostMapping("/login")
//	public String login(
//			@RequestParam String username,
//            @RequestParam String password, 
//            Model model) {
//		
//		if (true) {
//			return "redirect:/home";
//		}
//		return "redirect:/auth/login?error";
//	}

	// 로그아웃 페이지를 생성한다.
	@RequestMapping("/logout")
	public String logoutForm() {
		return "auth/logoutForm";
	}
}
