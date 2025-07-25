package com.kh.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.common.exception.NotMyItemException;
import com.kh.common.security.domain.CustomUser;
import com.kh.domain.Member;
import com.kh.domain.UserItem;
import com.kh.service.UserItemService;

@Controller
@RequestMapping("/useritem")
public class UserItemController {

	@Autowired
	private UserItemService service;

	@Value("${upload.path}")
	private String uploadPath;

	// 회원 구매 상품 목록
	@GetMapping("/list")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_MEMBER')")
	public void list(Model model, Authentication authentication) throws Exception {
		CustomUser customUser = (CustomUser) authentication.getPrincipal();
		Member member = customUser.getMember();
		int userNo = member.getUserNo();
		model.addAttribute("list", service.list(userNo));
	}

	// 구매 상품 보기
	@GetMapping("/read")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_MEMBER')")
	public void read(int userItemNo, Model model) throws Exception {
		model.addAttribute(service.read(userItemNo));
	}

	// 구매 상품 다운 로드
	@ResponseBody
	@RequestMapping("/download")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_MEMBER')")
	public ResponseEntity<byte[]> download(int userItemNo, Authentication authentication) throws Exception {
		UserItem userItem = service.read(userItemNo);
		// 구매한 상품이 사용자의 것인지 체크한다.
		CustomUser customUser = (CustomUser) authentication.getPrincipal();
		Member member = customUser.getMember();
		if (userItem.getUserNo() != member.getUserNo()) {
			throw new NotMyItemException("이것은 나의 구매 상품이 아니다.");
		}

		String fullName = userItem.getPictureUrl();
		InputStream in = null;
		ResponseEntity<byte[]> entity = null;
		try {
			HttpHeaders headers = new HttpHeaders();
			in = new FileInputStream(uploadPath + File.separator + fullName);

			String fileName = fullName.substring(fullName.indexOf("_") + 1);
			// MediaType.APPLICATION_OCTET_STREAM 바이너리 데이터를 처리
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			// 파이명을 utf-8에서 ISO-8859-1 수정한다.
			headers.add("Content-Disposition",
					"attachment;filename=\"" + new String(fileName.getBytes("UTF-8"), "ISO-8859-1") + "\"");
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		} finally {
			in.close();
		}
		return entity;
	}

	// 본인 상품 예외 처리
	@GetMapping("/notMyItem")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_MEMBER')")
	public void notMyItem(Model model) throws Exception {
	}
}