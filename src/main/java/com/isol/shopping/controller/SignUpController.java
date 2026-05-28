package com.isol.shopping.controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.isol.shopping.dto.SignUpRequest;
import com.isol.shopping.entity.UserData;
import com.isol.shopping.service.LoginService;

@Controller
public class SignUpController {

	private final LoginService loginService;

	public SignUpController(LoginService loginService) {
		this.loginService = loginService;
	}

	@GetMapping(value = "/shop/signUp")
	public String display(Model model) {
		return "shop/signUp";
	}

	/**
	 * 情報登録処理
	 * */
	@PostMapping("/shop/signUp")
	public String signUp(
			@ModelAttribute SignUpRequest signUpRequest,
			HttpSession session,
			Model model) {
		UserData userData = (UserData) session.getAttribute("loginUser");
		loginService.insertSignUpData(signUpRequest.getLoginId(),
				signUpRequest.getUserName(),
				signUpRequest.getPassword(), signUpRequest.getAddress(), signUpRequest.getPhoneNumber());

		return "redirect:/shop/login";

	}

}
