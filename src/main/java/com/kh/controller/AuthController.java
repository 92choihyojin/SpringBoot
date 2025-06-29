package com.kh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.service.AuthService;

@Controller
@RequestMapping("/auth")
public class AuthController {
	@Autowired
	private AuthService authService;
	
	// 목록 페이지
		@GetMapping("/list")
		public void list(Model model) throws Exception {
			model.addAttribute("list", authService.selectAll());
		}

}
