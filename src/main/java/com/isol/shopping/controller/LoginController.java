package com.isol.shopping.controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.isol.shopping.dto.LoginRequest;
import com.isol.shopping.entity.UserData;
import com.isol.shopping.service.LoginService;
import com.isol.shopping.utillity.LogUtil;

@Controller
public class LoginController {

	private final LoginService loginService;

	public LoginController(LoginService loginService) {
		this.loginService = loginService;
	}

	@GetMapping(value = "/shop/login")
	public String display(Model model) { 
	    model.addAttribute("loginRequest", new LoginRequest()); 
	    LogUtil.info("ログイン画面の表示要求を受け付けました。");
	    return "shop/login";
	}

	/**
	 * ログイン処理
	 * */
	@PostMapping("/shop/login")
	public String login(
			@Validated @ModelAttribute LoginRequest loginRequest, //@ModelAttribute自動的に格納してくれる
			BindingResult bindingResult, //バリデーションエラーを格納する
			HttpSession session, //一時的にユーザー情報を持つ　再度ログインを防げる
			Model model//javaとHTMLをつなぐ
	) {
		if (bindingResult.hasErrors()) {
			LogUtil.warn("IDまたはパスワードが足りません");
			return "shop/login";
		}
		UserData user = loginService.loginJudge(loginRequest.getLoginId(), loginRequest.getPassword());

		if (user != null) {
			session.setAttribute("loginUser", user);
			return "redirect:/shop/menu";

		} else {
			model.addAttribute("error", "IDまたはパスワードが違います");
			return "shop/login";
		}

	}

}